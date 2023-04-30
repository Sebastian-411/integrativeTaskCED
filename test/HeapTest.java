import model.dataStructure.Heap;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    static Heap<Integer,String > heap;
    public void setUpStage1(){
        heap = new Heap<>();
    }

    @Test
    public void insertInAnEmptyHeap(){

        setUpStage1();

        heap.insert(23, "1");
        assertEquals(23,heap.getList().get(0).getKey());
        assertEquals(1, heap.getHeapSize());
    }
}
