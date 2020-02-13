package bin.hex.calculator1;

import org.junit.Test;

import bin.hex.calculator1.util.Log;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void tempTest(){
        int a = 5;
        int b = 7;
//        0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a | b));
    }

    @Test
    public void test2(){
        int parsed = Integer.parseInt("0111", 2);
        System.out.println("Parsed value: " + parsed);
        System.out.println(Integer.toBinaryString(parsed));

    }

}