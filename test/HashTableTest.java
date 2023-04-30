import model.dataStructure.HashTable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {



    private static HashTable<String, Integer> hashTable;

    public void setupStage1(){
        hashTable = new HashTable<>(5);
    }
    public void setupStage2(){
        hashTable = new HashTable<>(5);
        hashTable.insert("AAAA",1);
        hashTable.insert("BBCC",2);
        hashTable.insert("CCDD",3);
        hashTable.insert("DDEE",4);
        hashTable.insert("EEFF",5);
        hashTable.insert("FFGG",6);
        hashTable.insert("GGHH",7);
        hashTable.insert("HHII",8);
        hashTable.insert("IIJJ",9);
        hashTable.insert("JJKK",10);
        hashTable.insert("KKLL",11);
        hashTable.insert("LLMM",12);
    }


    //Prueba Estándar
    @Test
    public void insertBasicTest(){
        setupStage1();
        hashTable.insert("AAAA",1);
        hashTable.insert("BBCC",2);
        hashTable.insert("CCDD",3);
        System.out.println(hashTable.print());
        assertEquals(hashTable.getListOfNodes()[0].getKey() , "CCDD");

    }
    @Test
    public void searchBasicTest(){
        setupStage1();
        hashTable.insert("AAAA",1);
        hashTable.insert("BBCC",2);
        hashTable.insert("CCDD",3);
        assertEquals(1, hashTable.search("AAAA"));
        assertEquals(2, hashTable.search("BBCC"));
        assertEquals(3, hashTable.search("CCDD"));
    }
    @Test
    public void deleteBasicTest(){
        setupStage1();
        hashTable.insert("AAAA",1);
        assertEquals(1, hashTable.search("AAAA"));
        assertTrue(hashTable.delete("AAAA"));
        assertNull(hashTable.search("AAAA"));
    }


    


}
