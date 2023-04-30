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

    @Test
    public void interestingTest(){
        setupStage2();
        for (int i = 0; i < 100; i++) {
            hashTable.insert(("" +i+i+i+i) , (i*5));
        }

        String test = "0. Key: 98989898 | C: 94949494 90909090 86868686 82828282 78787878 74747474 66666666 58585858 41414141 33333333 25252525 21212121 17171717 13131313 7777 2222 HHII CCDD AAAA \n" +
                "1. Key: 93939393 | C: 85858585 81818181 77777777 73737373 70707070 69696969 65656565 62626262 61616161 57575757 54545454 53535353 50505050 49494949 46464646 45454545 42424242 38383838 37373737 34343434 30303030 29292929 26262626 22222222 18181818 14141414 6666 1111 LLMM GGHH BBCC \n" +
                "2. Key: 91919191 | C: 83838383 80808080 75757575 72727272 71717171 67676767 64646464 63636363 60606060 59595959 56565656 55555555 52525252 51515151 48484848 47474747 44444444 43434343 40404040 39393939 36363636 35353535 32323232 28282828 27272727 24242424 16161616 5555 0000 KKLL FFGG \n" +
                "3. Key: 96969696 | C: 92929292 88888888 84848484 76767676 68686868 31313131 23232323 19191919 15151515 11111111 9999 4444 JJKK EEFF \n" +
                "4. Key: 99999999 | C: 97979797 95959595 89898989 87878787 79797979 20202020 12121212 10101010 8888 3333 IIJJ DDEE \n";


        assertEquals(test, hashTable.print());
        assertEquals(9, hashTable.search("IIJJ"));
        assertEquals(10, hashTable.search("JJKK"));
        assertEquals(11, hashTable.search("KKLL"));
        assertEquals(12, hashTable.search("LLMM"));
        assertEquals(330, hashTable.search("66666666"));
        assertEquals(5, hashTable.search("1111"));
        assertTrue(hashTable.delete("66666666"));
        assertNull(hashTable.search("66666666"));
        assertEquals(70, hashTable.search("14141414"));
        assertTrue(hashTable.delete("GGHH"));
        assertNull(hashTable.search("GGHH"));
        assertTrue(hashTable.delete("14141414"));
        assertNull(hashTable.search("14141414"));
        assertEquals(2, hashTable.search("BBCC"));
        assertTrue(hashTable.delete("BBCC"));
        assertNull(hashTable.search("BBCC"));
        for (int i = 0; i < 100; i++) {
            hashTable.insert(("" +i+i+i+i+i) , (i*10));
        }

        assertEquals(3, hashTable.search("CCDD"));
        assertEquals(4, hashTable.search("DDEE"));
        assertEquals(5, hashTable.search("EEFF"));
        assertEquals(6, hashTable.search("FFGG"));
        assertEquals(660, hashTable.search("6666666666"));
        assertEquals(50, hashTable.search("55555"));
        assertTrue(hashTable.delete("6666666666"));
        assertNull(hashTable.search("6666666666"));
        assertEquals(150, hashTable.search("1515151515"));
        assertTrue(hashTable.delete("LLMM"));
        assertNull(hashTable.search("LLMM"));
        assertFalse(hashTable.delete("14141414"));
        assertNull(hashTable.search("14141414"));
        assertEquals(465, hashTable.search("93939393"));
        assertTrue(hashTable.delete("93939393"));
        assertNull(hashTable.search("93939393"));
    }


}
