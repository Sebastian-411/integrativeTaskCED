package model.serializers;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Serializer<K> implements JsonSerializer<K>, JsonDeserializer {

    private static final String CLASS_TYPE = "CLASS_TYPE";
    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        String className = jsonObj.get(CLASS_TYPE).getAsString();
        try {
            Class<?> clz = Class.forName(className);
            return jsonDeserializationContext.deserialize(jsonElement, clz);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public JsonElement serialize(K k, Type type, JsonSerializationContext jsonSerializationContext) {
        Gson gson = new Gson(); //without this line it will not work
        gson.toJson(k, k.getClass()); //and this one
        JsonElement jsonElement = gson.toJsonTree(k); //it needs to replace to another method...toJsonTree
        jsonElement.getAsJsonObject().addProperty(CLASS_TYPE, k.getClass().getCanonicalName());
        return jsonElement;
    }
}
