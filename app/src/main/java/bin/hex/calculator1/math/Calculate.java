package bin.hex.calculator1.math;

import bin.hex.calculator1.util.Log;

public class Calculate {
//PARITY BIT -  https://www.techiedelight.com/compute-parity-number-using-lookup-table/ 
    //class Main
//{
//	// Function to find parity of number x
//	public static boolean findParity(int x)
//	{
//
//		// recursively divide the (32-bit) integer into two equal
//		// halves and take their XOR until only 1 bit is left
//
//		x = (x & 0x0000FFFF)^(x >> 16);
//		x = (x & 0x000000FF)^(x >> 8);
//		x = (x & 0x0000000F)^(x >> 4);
//		x = (x & 0x00000003)^(x >> 2);
//		x = (x & 0x00000001)^(x >> 1);
//
//		// return the last bit
//		return (x & 1) == 1;
//	}
//
//	public static void main(String[] args)
//	{
//		int x = 127; // значение , которое нужно ввести  ()
//
//		System.out.println(x + " in binary is " + Integer.toBinaryString(x));
//
//		if (findParity(x)) {
//			System.out.println(x + " contains odd bits"); // ответ с введенным числом + contains odd bits
//		}
//		else {
//			System.out.println(x + " contains even bits"); // ответ с введенным числом + contains even bits
//		}
//	}
//}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//GRAY TO BINARY  -  https://www.geeksforgeeks.org/gray-to-binary-and-binary-to-gray-conversion/

    //import java.io.*;
//class code_conversion {
//    // Helper function to xor
//    // two characters
//    char xor_c(char a, char b)
//    {
//        return (a == b) ? '0' : '1';
//    }
//
//    // Helper function to flip the bit
//    char flip(char c)
//    {
//        return (c == '0') ? '1' : '0';
//    }
    //   // function to convert gray code
//    // string to binary string
//    String graytoBinary(String gray)
//    {
//        String binary = "";
//
//        // MSB of binary code is same
//        // as gray code
//        binary += gray.charAt(0);
//
//        // Compute remaining bits
//        for (int i = 1; i < gray.length(); i++) {
//            // If current bit is 0,
//            // concatenate previous bit
//            if (gray.charAt(i) == '0')
//                binary += binary.charAt(i - 1);
//
//            // Else, concatenate invert of
//            // previous bit
//            else
//                binary += flip(binary.charAt(i - 1));
//        }
//
//        return binary;
//    }
    //// Driver program to test above functions
    //int main()
    //{
    //
    //    string gray = "01101"; // значение для ввода в бинарной форме
    //    cout << "Binary code of " << gray << " is "
    //         << graytoBinary(gray) << endl;
    //    return 0;
    //}
    // Result (в этом примере выглядит в такой форсе) : Gray code of 01001 is 01101
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //HAMMING CODE -  https://www.geeksforgeeks.org/hamming-code-implementation-in-java/
    //// Java code to implement Hamming Code
//class HammingCode {
//
//    // print elements of array
//    static void print(int ar[])
//    {
//        for (int i = 1; i < ar.length; i++) {
//            System.out.print(ar[i]);
//        }
//        System.out.println();
//    }
//
//    // calculating value of redundant bits
//    static int[] calculation(int[] ar, int r)
//    {
//        for (int i = 0; i < r; i++) {
//            int x = (int)Math.pow(2, i);
//            for (int j = 1; j < ar.length; j++) {
//                if (((j >> i) & 1) == 1) {
//                    if (x != j)
//                        ar[x] = ar[x] ^ ar[j];
//                }
//            }
//            System.out.println("r" + x + " = "
//                               + ar[x]);
//        }
//
//        return ar;
//    }
//
//    static int[] generateCode(String str, int M, int r)
//    {
//        int[] ar = new int[r + M + 1];
//        int j = 0;
//        for (int i = 1; i < ar.length; i++) {
//            if ((Math.ceil(Math.log(i) / Math.log(2))
//                 - Math.floor(Math.log(i) / Math.log(2)))
//                == 0) {
//
//                // if i == 2^n for n in (0, 1, 2, .....)
//                // then ar[i]=0
//                // codeword[i] = 0 ----
//                // redundant bits are intialized
//                // with value 0
//                ar[i] = 0;
//            }
//            else {
//
//                // codeword[i] = dataword[j]
//                ar[i] = (int)(str.charAt(j) - '0');
//                j++;
//            }
//        }
//        return ar;
//    }
//
//    // Driver code
//    public static void main(String[] args)
//    {
//
//        // input message
//        String str = "0101"; // значение для ввода
//        int M = str.length();
//        int r = 1;
//
//        while (Math.pow(2, r) < (M + r + 1)) {
//            // r is number of redundant bits
//            r++;
//        }
//        int[] ar = generateCode(str, M, r);
//
//        System.out.println("Generated hamming code "); // поле для ответа
//        ar = calculation(ar, r);
//        print(ar);
//    }
//}
    // Result (в данном примере выглядит так ) :
    //Generated hamming code
    //r1 = 0  // r1 , r2 , r4 -  это лишние биты
    //r2 = 1
    //r4 = 0
    //0100101
    public enum NumeralSystem{
        BIN, DEC, HEX;

        public static NumeralSystem get(String v){
            switch (v.toLowerCase()){
                default:
                    Log.log("Unknown numeral system '"+v+"'");
                    return null;
                case "bin":
                    return Calculate.NumeralSystem.BIN;
                case "dec":
                    return Calculate.NumeralSystem.DEC;
                case "hex":
                    return Calculate.NumeralSystem.HEX;

            }
        }
    }

    public enum ConvertType{
        HAMMING("Hamming"), GRAY("Gray"), PARITY("Parity");
        private String name;

        ConvertType(String name){
            this.name = name;
        }

        public static ConvertType get(String v){
            switch (v.toLowerCase()){
                default:
                    Log.log("Unknown convert type '"+v+"'");
                    return null;
                case "hamming":
                    return HAMMING;
                case "gray":
                    return GRAY;
                case "parity":
                    return PARITY;

            }
        }

    }

    public enum Operator{
        AND, OR, XOR, NOT, SH_L, SH_R;

        public static Operator get(String v){
            switch (v){
                default:
                    return null;
                case "and":
                    return Calculate.Operator.AND;
                case "or":
                    return Calculate.Operator.OR;
                case "xor":
                    return Calculate.Operator.XOR;
                case "not":
                    return Calculate.Operator.NOT;
                case "sh-l":
                    return Calculate.Operator.SH_L;
                case "sh-r":
                    return Calculate.Operator.SH_R;
            }
        }
    }

    public enum Bit{
        BITS_8("%8s"),
        BITS_16("%16s"),
        BITS_32("%32s");

        String formatVal;

        Bit(String formatVal){
            this.formatVal = formatVal;
        }

        String getFormatVal(){
            return formatVal;
        }

        public static Bit get(String v){
            switch (v){
                default:
                    return null;
                case "8bits":
                    return BITS_8;
                case "16bits":
                    return BITS_16;
                case "32bits":
                    return BITS_32;
            }
        }

    }


    private static Integer calculateOperator(int x, int y, Operator o){
        switch (o){
            default:
                Log.log("Not valid operator for bin <" + o + ">.");
                return 0;
            case SH_L:
                return shitLeft(x, y);
            case SH_R:
                return shitRight(x, y);
            case AND:
                return x & y;
            case OR:
                return x | y;
            case XOR:
                return x ^ y;
            case NOT:
                return ~x;
        }
    }

    private static Integer shitLeft(int value, int position){
        return value << position;
    }

    private static Integer shitRight(int value, int position){
        return value >> position;
    }


    public static String getBin(String x, String y, Operator o){
        int v1 = Integer.parseInt(x, 2);
        int v2;
        if(o == Operator.SH_L || o == Operator.SH_R){
            v2 = Integer.parseInt(y);
        }else{
            v2 = Integer.parseInt(y, 2);
        }
        int result = calculateOperator(v1, v2, o);
        return Integer.toBinaryString(result);
    }

    public static String getDec(String x, String y, Operator o){
        int v1 = Integer.parseInt(x);
        int v2 = Integer.parseInt(y);
        return String.valueOf(calculateOperator(v1, v2, o));
    }

    public static String getHex(String x, String y, Operator o){
        int v1 = Integer.parseInt(x, 16);
        int v2 = Integer.parseInt(y, 16);
        System.out.println("Converted INT (from hex) value1 = '"+v1+"', value2 = '"+v2+"'");
        int result = calculateOperator(v1, v2, o);
        return Integer.toHexString(result);
    }

    public static String toBinary(int x, Bit bit){
        return String.format(bit.getFormatVal(), Integer.toBinaryString(x)).replaceAll(" ", "0");
    }

    public static String convertHamming(String initial){
        return "not implemented"; //TODO
    }

    public static String convertToGray(String initial){
        return "not implemented"; //TODO
    }

    public static String convertParity(String initial){
        return "not implemented"; //TODO
    }


    // Java program to illustrate
// bitwise operators
   /* public class operators {
        public static void main(String[] args)
        {
            //Initial values
            int a = 5;
            int b = 7;

            // bitwise AND
            // 0101 & 0111=0101 = 5
            System.out.println("a&b = " + (a & b));

            // bitwise OR
            // 0101 | 0111=0111 = 7
            System.out.println("a|b = " + (a | b));

            // bitwise XOR
            // 0101 ^ 0111=0010 = 2
            System.out.println("a^b = " + (a ^ b));

            // bitwise AND
            // ~0101=1010
            // will give 2's complement of 1010 = -6
            System.out.println("~a = " + ~a);

            // can also be combined with
            // assignment operator to provide shorthand
            // assignment
            // a=a&b
            a &= b;
            System.out.println("a= " + a);
        }
    }
    // Java program to illustrate
// SHIFT operators
public class operators {
    public static void main(String[] args)
    {

        int a = 5;
        int b = -10;

        // LEFT shift operator
        // 0000 0101<<2 =0001 0100(20)
        // similar to 5*(2^2)
        System.out.println("a<<2 = " + (a << 2));

        // RIGHT shift operator
        // 0000 0101 >> 2 =0000 0001(1)
        // similar to 5/(2^2)
        System.out.println("b>>2 = " + (b >> 2));
    }
}
    */

}
