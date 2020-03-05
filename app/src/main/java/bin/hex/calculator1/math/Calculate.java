package bin.hex.calculator1.math;

import java.math.BigInteger;

import bin.hex.calculator1.util.Log;

public class Calculate {
//BINARY TO DECIMAL
    //1.	public class BinaryDecimal {
//2.
//3.	    public static void main(String[] args) {
//4.	        long num = 110110111;
//5.	        int decimal = convertBinaryToDecimal(num);
//6.	        System.out.printf("%d in binary = %d in decimal", num, decimal);
//7.	    }
//8.
//9.	    public static int convertBinaryToDecimal(long num)
//10.	    {
//11.	        int decimalNumber = 0, i = 0;
//12.	        long remainder;
//13.	        while (num != 0)
//14.	        {
//15.	            remainder = num % 10;
//16.	            num /= 10;
//17.	            decimalNumber += remainder * Math.pow(2, i);
//18.	            ++i;
//19.	        }
//20.	        return decimalNumber;
//21.	    }
//22.	}
////////////////////////////////////////////////////////////////////////////////////////////

//DECIMAL TO BINARY
//1.	public class DecimalBinary {
//2.
//3.	    public static void main(String[] args) {
//4.	        int num = 19;
//5.	        long binary = convertDecimalToBinary(num);
//6.	        System.out.printf("%d in decimal = %d in binary", num, binary);
//7.	    }
//8.
//9.	    public static long convertDecimalToBinary(int n)
//10.	    {
//11.	        long binaryNumber = 0;
//12.	        int remainder, i = 1, step = 1;
//13.
//14.	        while (n!=0)
//15.	        {
//16.	            remainder = n % 2;
//17.	            System.out.printf("Step %d: %d/2, Remainder = %d, Quotient = %d\n", step++, n, remainder, n/2);
//18.	            n /= 2;
//19.	            binaryNumber += remainder * i;
//20.	            i *= 10;
//21.	        }
//22.	        return binaryNumber;
//23.	    }
//24.	}
 /////////////////////////////////////////////////////////////////////////////////////////////////

    //BINARY TO HEX , https://www.sanfoundry.com/java-program-convert-binary-hexadecimal/
    //import java.util.Scanner;
//class Binary_Hexa
//   {
//                 Scanner scan;
//	int num;
//	void getVal()
//	    {
//		System.out.println("Binary to HexaDecimal");
//		scan = new Scanner(System.in);
//		System.out.println("\nEnter the number :");
//		num = Integer.parseInt(scan.nextLine(), 2);
//	    }
//	void convert()
//	   {
//		String hexa = Integer.toHexString(num);
//		System.out.println("HexaDecimal Value is : " + hexa);
//	   }
//    }
//class Main_Class
// {
//           public static void main(String... q)
//            {
//	Binary_Hexa obj = new Binary_Hexa();
//	obj.getVal();
//	obj.convert();
//              }
//}
    ////////////////////////////////////////////////////////////////////////////////////////////////

    //HEX TO BINARY , https://www.sanfoundry.com/java-program-convert-hexadecimal-binary/
    //import java.util.Scanner;
//class Hexa_Binary
//     {
//                 Scanner scan;
//	int num;
//	void getVal()
//                     {
//        		System.out.println("HexaDecimal to Binary");
//		scan = new Scanner(System.in);
//		System.out.println("\nEnter the number :");
//		num = Integer.parseInt(scan.nextLine(), 16);
//	    }
//	void convert()
//    	   {
//		String binary = Integer.toBinaryString(num);
//		System.out.println("Binary Value is : " + binary);
//	   }
//     }
//class MainClass
//{
//         public static void main(String args[])
//            {
//	Hexa_Binary obj = new Hexa_Binary();
//	obj.getVal();
//	obj.convert();
//            }
//}
///////////////////////////////////////////////////////////////////////////////////////////////////
 //DEC TO HEX , https://www.geeksforgeeks.org/program-decimal-hexadecimal-conversion/
    //// Java program to convert a decimal
    //// number to hexadecimal number
    //import java.io.*;
    //
    //class GFG
    //{
    //    // function to convert decimal to hexadecimal
    //    static void decToHexa(int n)
    //    {
    //        // char array to store hexadecimal number
    //        char[] hexaDeciNum = new char[100];
    //
    //        // counter for hexadecimal number array
    //        int i = 0;
    //        while(n!=0)
    //        {
    //            // temporary variable to store remainder
    //            int temp  = 0;
    //
    //            // storing remainder in temp variable.
    //            temp = n % 16;
    //
    //            // check if temp < 10
    //            if(temp < 10)
    //            {
    //                hexaDeciNum[i] = (char)(temp + 48);
    //                i++;
    //            }
    //            else
    //            {
    //                hexaDeciNum[i] = (char)(temp + 55);
    //                i++;
    //            }
    //
    //            n = n/16;
    //        }
    //
    //        // printing hexadecimal number array in reverse order
    //        for(int j=i-1; j>=0; j--)
    //            System.out.print(hexaDeciNum[j]);
    //    }
    //
    //    // driver program
    //    public static void main (String[] args)
    //    {
    //        int n = 2545;
    //        decToHexa(n);
    //    }
    //}
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////

 //HEX TO DEC , https://www.geeksforgeeks.org/program-for-hexadecimal-to-decimal/
    //// Java program to convert hexadecimal to decimal
 //import java.io.*;
 //
 //class GFG
 //{
 //    // Function to convert hexadecimal to decimal
 //    static int hexadecimalToDecimal(String hexVal)
 //    {
 //        int len = hexVal.length();
 //
 //        // Initializing base value to 1, i.e 16^0
 //        int base = 1;
 //
 //        int dec_val = 0;
 //
 //        // Extracting characters as digits from last character
 //        for (int i=len-1; i>=0; i--)
 //        {
 //            // if character lies in '0'-'9', converting
 //            // it to integral 0-9 by subtracting 48 from
 //            // ASCII value
 //            if (hexVal.charAt(i) >= '0' && hexVal.charAt(i) <= '9')
 //            {
 //                dec_val += (hexVal.charAt(i) - 48)*base;
 //
 //                // incrementing base by power
 //                base = base * 16;
 //            }
 //
 //            // if character lies in 'A'-'F' , converting
 //            // it to integral 10 - 15 by subtracting 55
 //            // from ASCII value
 //            else if (hexVal.charAt(i) >= 'A' && hexVal.charAt(i) <= 'F')
 //            {
 //                dec_val += (hexVal.charAt(i) - 55)*base;
 //
 //                // incrementing base by power
 //                base = base*16;
 //            }
 //        }
 //        return dec_val;
 //    }
 //
 //    // driver program
 //    public static void main (String[] args)
 //    {
 //        String hexNum = "1A";
 //        System.out.println(hexadecimalToDecimal(hexNum));
 //    }
 //}
    //////////////////////////////////////////////////////////////////////////////////////////////
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
        return HammingCode.calculate(initial);
    }

    public static String convertToGray(String initial){
        return GrayCode.binaryToGray(initial);
    }

    public static String convertParity(String initial){
        return ParityCode.calculate(initial);
    }

    public static String binToDec(String bin){
        int decimal = Integer.parseInt(bin, 2);
        return String.valueOf(decimal);
    }

    public static String binToHex(String bin){
        int decimal = Integer.parseInt(bin,2);
        return Integer.toString(decimal,16);
    }

    public static String decToBin(String dec){
        int d = Integer.parseInt(dec);
        return Integer.toBinaryString(d);
    }

    public static String decToHex(String dec){
        int d = Integer.parseInt(dec);
        return Integer.toHexString(d);
    }

    public static String hexToBin(String hex){
        return new BigInteger(hex, 16).toString(2);
    }

    public static String hexToDec(String hex){
        int decimal = Integer.parseInt(hex,16);
        return Integer.toString(decimal);
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
