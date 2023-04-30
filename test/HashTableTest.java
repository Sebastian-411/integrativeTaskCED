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


    @Test
    public void insertAdvancedTest(){
        setupStage1();
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

        String test = "0. Key: HHII | C: CCDD AAAA \n" +
                "1. Key: LLMM | C: GGHH BBCC \n" +
                "2. Key: KKLL | C: FFGG \n" +
                "3. Key: JJKK | C: EEFF \n" +
                "4. Key: IIJJ | C: DDEE \n";


        assertEquals(test , hashTable.print());
        assertEquals(hashTable.getListOfNodes()[0].getKey() , "HHII");
        assertEquals(hashTable.getListOfNodes()[1].getKey() , "LLMM");
        assertEquals(hashTable.getListOfNodes()[2].getKey() , "KKLL");
        assertEquals(hashTable.getListOfNodes()[3].getKey() , "JJKK");
        assertEquals(hashTable.getListOfNodes()[4].getKey() , "IIJJ");

        assertEquals(hashTable.getListOfNodes()[0].getNext().getKey() , "CCDD");
        assertEquals(hashTable.getListOfNodes()[1].getNext().getKey() , "GGHH");
        assertEquals(hashTable.getListOfNodes()[2].getNext().getKey() , "FFGG");
        assertEquals(hashTable.getListOfNodes()[3].getNext().getKey() , "EEFF");
        assertEquals(hashTable.getListOfNodes()[4].getNext().getKey() , "DDEE");

        assertEquals(hashTable.getListOfNodes()[0].getNext().getNext().getKey() , "AAAA");
        assertEquals(hashTable.getListOfNodes()[1].getNext().getNext().getKey() , "BBCC");


    }

    @Test
    public void searchAdvancedTest(){
        setupStage2();

        assertEquals(1, hashTable.search("AAAA"));
        assertEquals(2, hashTable.search("BBCC"));
        assertEquals(3, hashTable.search("CCDD"));
        assertEquals(4, hashTable.search("DDEE"));
        assertEquals(5, hashTable.search("EEFF"));
        assertEquals(6, hashTable.search("FFGG"));
        assertEquals(7, hashTable.search("GGHH"));
        assertEquals(8, hashTable.search("HHII"));
        assertEquals(9, hashTable.search("IIJJ"));
        assertEquals(10, hashTable.search("JJKK"));
        assertEquals(11, hashTable.search("KKLL"));
        assertEquals(12, hashTable.search("LLMM"));

    }

    @Test
    public void deleteAdvancedTest(){
        setupStage2();

        assertTrue(hashTable.delete("AAAA"));
        assertNull(hashTable.search("AAAA"));

        assertTrue(hashTable.delete("BBCC"));
        assertNull(hashTable.search("BBCC"));

        assertTrue(hashTable.delete("CCDD"));
        assertNull(hashTable.search("CCDD"));

        assertTrue(hashTable.delete("DDEE"));
        assertNull(hashTable.search("DDEE"));

        assertTrue(hashTable.delete("EEFF"));
        assertNull(hashTable.search("EEFF"));

        assertTrue(hashTable.delete("FFGG"));
        assertNull(hashTable.search("FFGG"));

        assertTrue(hashTable.delete("GGHH"));
        assertNull(hashTable.search("GGHH"));

        assertTrue(hashTable.delete("HHII"));
        assertNull(hashTable.search("HHII"));

        assertTrue(hashTable.delete("IIJJ"));
        assertNull(hashTable.search("IIJJ"));

        assertTrue(hashTable.delete("JJKK"));
        assertNull(hashTable.search("JJKK"));

        assertTrue(hashTable.delete("KKLL"));
        assertNull(hashTable.search("KKLL"));

        assertTrue(hashTable.delete("LLMM"));
        assertNull(hashTable.search("LLMM"));

    }


}
