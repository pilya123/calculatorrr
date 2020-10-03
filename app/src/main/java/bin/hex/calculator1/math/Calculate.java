package bin.hex.calculator1.math;

import java.math.BigInteger;

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

    public enum CodingType{
        CRC_8, CRC_16, CRC_32;

        public static CodingType get(String v){
            if(v.contains("8")){
                return CRC_8;
            }
            if(v.contains("16")){
                return CRC_16;
            }
            if (v.contains("32")){
                return CRC_32;
            }
            Log.log("Unknown coding type '"+v+"'");
            return null;
        }
    }

    public enum ConvertType{
        HAMMING("Hamming"), GRAY("Gray"), PARITY("Parity");
        private String name;

        ConvertType(String name){
            this.name = name;
        }

        @Deprecated
        public static ConvertType get(String v){
            switch (v.toLowerCase()){
                default:
                    Log.log("Convert type '"+v+"'");
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

    public enum GreyConvertType {
        GREY_TO_BIN("Grey to bin"), GRAY_TO_HEX("Gray to hex");
        private String name;

        GreyConvertType(String name){
            this.name = name;
        }

        public static GreyConvertType get(String v){
            switch (v.toLowerCase()){
                default:
                    Log.log("Unknown convert type '"+v+"'");
                    return null;
                case "gray to bin":
                    return GREY_TO_BIN;
                case "gray to hex":
                    return GRAY_TO_HEX;
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


    private static Long calculateOperator(long x, long y, Operator o){
        switch (o){
            default:
                Log.log("Not valid operator for bin <" + o + ">.");
                return 0L;
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

    private static Long shitLeft(long value, long position){
        return value << position;
    }

    private static Long shitRight(long value, long position){
        return value >> position;
    }


    public static String getBin(String x, String y, Operator o){
        long v1 = Long.parseLong(x, 2);
        long v2;
        if(o == Operator.SH_L || o == Operator.SH_R){
            v2 = Long.parseLong(y);
        }else{
            v2 = Long.parseLong(y, 2);
        }
        long result = calculateOperator(v1, v2, o);
        return Long.toBinaryString(result);
    }

    public static String getDec(String x, String y, Operator o){
        long v1 = Long.parseLong(x);
        long v2 = Long.parseLong(y);
        return String.valueOf(calculateOperator(v1, v2, o));
    }

    public static String getHex(String x, String y, Operator o){
        long v1 = Long.parseLong(x, 16);
        long v2 = Long.parseLong(y, 16);
        System.out.println("Converted INT (from hex) value1 = '"+v1+"', value2 = '"+v2+"'");
        long result = calculateOperator(v1, v2, o);
        return Long.toHexString(result);
    }

    public static String toBinary(long x, Bit bit){
        return String.format(bit.getFormatVal(), Long.toBinaryString(x)).replaceAll(" ", "0");
    }

    public static String convertHamming(String initial){
        return HammingCode.calculate(initial);
    }

    public static String convertEndianness(String initial, boolean isLittle){
        return EndianConvert.convert(initial, isLittle);
    }

    public static String convertGrayToBin(String initial){
        return GrayCode.grayToBinary(initial);
    }

    public static String greyToHex(String initial){
        //TODO: add formula
        return "<not yet implemented>";
    }

    public static String convertParity(String initial){
        return ParityCode.calculate(initial);
    }

    public static String binToDec(String bin){
        long decimal = Long.parseLong(bin, 2);
        return String.valueOf(decimal);
    }

    public static String binToHex(String bin){
        long decimal = Long.parseLong(bin,2);
        return Long.toString(decimal,16);
    }

    public static String decToBin(String dec){
        long d = Long.parseLong(dec);
        return Long.toBinaryString(d);
    }

    public static String decToHex(String dec){
        long d = Long.parseLong(dec);
        return Long.toHexString(d);
    }

    public static String hexToBin(String hex){
        return new BigInteger(hex, 16).toString(2);
    }

    public static String hexToDec(String hex){
        long decimal = Long.parseLong(hex,16);
        return Long.toString(decimal);
    }




}
