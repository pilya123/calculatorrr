package bin.hex.calculator1.math;

import bin.hex.calculator1.util.Log;

public class Calculate {
    // 1)не работает кнопка OR
// 2) когда использую кнопку sh-l/r - выводит: Please select a valid operator / Please populate values for calculation( не выбрасывает из программы ), но  не считает.
// 3) при использовании hex : 1. and - выводит в ответе верхнее значение , которое мы ввели. 2. xor - при всех значениях выводит 0.
    // все остальное работает отлично
    // еще добавил комментарии кода для спинера(8-16-32 битов) в MainActivity(строчка 50)
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
                case "sh-l":
                    return Calculate.Operator.SH_L;
                case "sh-r":
                    return Calculate.Operator.SH_R;
            }
        }
    }

    public enum Bit{
        BITS_8, BITS_16, BITS_32;

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
        int v2 = Integer.parseInt(y, 2);
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
