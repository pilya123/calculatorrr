package bin.hex.calculator1;

import org.junit.Test;

import bin.hex.calculator1.math.Calculate;
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
        System.out.println(Calculate.getHex("1", "4", Calculate.Operator.XOR));

    }

}