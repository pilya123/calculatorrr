package bin.hex.calculator1;

import bin.hex.calculator1.math.Calculate;

import static bin.hex.calculator1.math.Calculate.ConvertType.HAMMING;

public class CalculatorState {

    private static Calculate.ConvertType CONVERT_TYPE = HAMMING;


    public static void setConvertType(Calculate.ConvertType type){
        CONVERT_TYPE = type;
    }

    public static Calculate.ConvertType getConvertType(){
        return CONVERT_TYPE;
    }
}
