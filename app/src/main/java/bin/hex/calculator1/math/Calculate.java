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



}
