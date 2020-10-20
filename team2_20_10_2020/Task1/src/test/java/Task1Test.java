import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task1Test {
    @Test
    public void testAllNumbersEqual(){
        int[] array = {0,0,0,0,0};
        int l = Task1.solution(array, 0).getKey();
        int r = Task1.solution(array, 0).getValue();
        assertEquals(0, l);
        assertEquals(4, r);
    }
    @Test
    public void testTheFirstElement(){
        int[] array = {1,2,3,4};
        int l = Task1.solution(array, 1).getKey();
        int r = Task1.solution(array, 1).getValue();
        assertEquals(0, l);
        assertEquals(0, r);
    }
    @Test
    public void testInTheMiddle(){
        int[] array = {1,2,3,4,4,4,4,5,6};
        int l = Task1.solution(array, 4).getKey();
        int r = Task1.solution(array, 4).getValue();
        assertEquals(3, l);
        assertEquals(6, r);
    }
    @Test
    public void testNoEntry(){
        int[] array = {1,2,3,4,4,4,4,5,6};
        int l = Task1.solution(array, 10).getKey();
        int r = Task1.solution(array, 10).getValue();
        assertEquals(-1, l);
        assertEquals(-1, r);
    }
    @Test
    public void inputTest(){
        int[] array = {5,7,7,8,8,10};
        int l = Task1.solution(array, 8).getKey();
        int r = Task1.solution(array, 8).getValue();
        assertEquals(3, l);
        assertEquals(4, r);
    }

}