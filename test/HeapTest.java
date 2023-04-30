import model.dataStructure.Heap;
import model.dataStructure.HeapNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    static Heap<Integer,String > heap ;
    public void setUpStage1(){
        heap = new Heap<>();
    }

    public void setUpStage2(){
        heap = new Heap<>();
        ArrayList<HeapNode<Integer,String >> setUp = new ArrayList<>();
        setUp.add(new HeapNode<>(12,"1"));
        setUp.add(new HeapNode<>(5,"5"));
        setUp.add(new HeapNode<>(6,"6"));
        heap.setList(setUp);
        heap.setHeapSize(3);
    }
    public void setUpStage3(){
        heap = new Heap<>();
        ArrayList<HeapNode<Integer,String >> setUp = new ArrayList<>();
        setUp.add(new HeapNode<>(4,"1"));
        setUp.add(new HeapNode<>(14,"2"));
        setUp.add(new HeapNode<>(7,"3"));
        setUp.add(new HeapNode<>(2,"4"));
        setUp.add(new HeapNode<>(8,"5"));
        setUp.add(new HeapNode<>(1,"6"));

        heap.setList(setUp);
        heap.setHeapSize(6);
    }
    public void setUpStage4(){
        heap = new Heap<>();
        ArrayList<HeapNode<Integer,String >> setUp = new ArrayList<>();
        setUp.add(new HeapNode<>(4,"1"));
        setUp.add(new HeapNode<>(1,"2"));
        setUp.add(new HeapNode<>(3,"3"));
        setUp.add(new HeapNode<>(2,"4"));
        setUp.add(new HeapNode<>(16,"5"));
        setUp.add(new HeapNode<>(9,"6"));
        setUp.add(new HeapNode<>(10,"7"));
        setUp.add(new HeapNode<>(14,"8"));
        setUp.add(new HeapNode<>(8,"9"));
        setUp.add(new HeapNode<>(7,"10"));

        heap.setList(setUp);
        heap.setHeapSize(10);
    }
    @Test
    public void insertInAnEmptyHeap(){
        setUpStage1();
        heap.insert(23, "1");
        assertEquals(23,heap.getList().get(0).getKey());
        assertEquals(1, heap.getHeapSize());
    }

    @Test
    public void insertNewRoot(){
        setUpStage2();
        heap.insert(15,"newRoot");
        assertEquals(15,heap.getmaX());
        assertEquals(4,heap.getHeapSize());
        assertEquals(12,heap.getList().get(1).getKey());
    }

    @Test
    public void maxHeapifyTest(){
        setUpStage3();
        heap.maxHeapify(0);
        assertEquals(14,heap.getmaX());
        assertEquals(8,heap.getList().get(1).getKey());
        assertEquals(4,heap.getList().get(4).getKey());
    }

    @Test
    public void buildHeapTest(){
        setUpStage4();
        heap.buildHeap();
        String chain= "";
        for (HeapNode node: heap.getList()
             ) {
            chain+=node.getKey() + " ";
        }
        assertEquals("16 14 10 8 7 9 3 2 4 1", chain.trim());
    }

    @Test
    public void heapSortTest(){
        setUpStage4();
        heap.heapSort();
        String chain= "";
        for (HeapNode node: heap.getList()
        ) {
            chain+=node.getKey() + " ";
        }
        assertEquals("1 2 3 4 7 8 9 10 14 16", chain.trim());
    }
}
