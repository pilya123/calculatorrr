package bin.hex.calculator1.math;

import bin.hex.calculator1.util.Log;

public class Calculate {

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
                case "sh_l":
                    return Calculate.Operator.SH_L;
                case "sh_r":
                    return Calculate.Operator.SH_R;
            }
        }
    }


    public static Integer getBin(int x, int y, Operator o){
        //TODO: logic for BIN should be added
        return 0;
    }

    public static Integer getDec(int x, int y, Operator o){
        //TODO: logic for DEC should be added
        return 0;
    }

    public static String getHex(int n, int numToShift, Operator o){
        //TODO: logic for HEX should be added
        return null;
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
