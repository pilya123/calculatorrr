package bin.hex.calculator1.math;

import bin.hex.calculator1.util.Log;

class ParityCode
{
    // Function to find parity of number x
    private static boolean findParity(int x)
    {
        // Hexacedimal to Binary conversion can be checked here
        // www.binaryhexconverter.com/hex-to-binary-converter

        // recursively divide the (32-bit) integer into two equal
        // halves and take their XOR until only 1 bit is left

        x = (x & 0x0000FFFF)^(x >> 16);
        x = (x & 0x000000FF)^(x >> 8);
        x = (x & 0x0000000F)^(x >> 4);
        x = (x & 0x00000003)^(x >> 2);
        x = (x & 0x00000001)^(x >> 1);

        // return the last bit
        return (x & 1) == 1;
    }

    static String calculate(String initial){
        int x = Integer.valueOf(initial);

        Log.log(x + " in binary is " + Integer.toBinaryString(x));

        String result;
        if (findParity(x)) {
            result = x + " contains odd bits";
            Log.log(result);
        }
        else {
            result = x + " contains even bits";
            Log.log(x + " contains even bits");
        }
        return result;

    }

//    public static void main(String[] args)
//    {
//        int x = 127;
//
//        System.out.println(x + " in binary is " + Integer.toBinaryString(x));
//
//        if (findParity(x)) {
//            System.out.println(x + " contains odd bits");
//        }
//        else {
//            System.out.println(x + " contains even bits");
//        }
//    }
}
