package bin.hex.calculator1;

import bin.hex.calculator1.math.Calculate;

import static bin.hex.calculator1.math.Calculate.ConvertType.HAMMING;

public class CalculatorState {

    private static Calculate.ConvertType CONVERT_TYPE = HAMMING;
    private static Calculate.GreyConvertType GREY_CONVERT = Calculate.GreyConvertType.GREY_TO_BIN;


    public static void setConvertType(Calculate.ConvertType type){
        CONVERT_TYPE = type;
    }

    public static Calculate.ConvertType getConvertType(){
        return CONVERT_TYPE;
    }

    public static void setGreyConvertType(Calculate.GreyConvertType type){
        GREY_CONVERT = type;
    }

    public static Calculate.GreyConvertType getGreyConvertType(){
        return GREY_CONVERT;
    }


}
