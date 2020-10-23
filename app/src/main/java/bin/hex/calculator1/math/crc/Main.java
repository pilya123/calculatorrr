package bin.hex.calculator1.math.crc;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Check(Crc8.Params);

        Check(Crc16.Params);

        Check(Crc32.Params);

        Check(Crc64.Params);
    }

    private static void Check(AlgoParams[] params)
    {
        for (AlgoParams param : params) {
            CrcCalculator calculator = new CrcCalculator(param);
            long result = calculator.calc(CrcCalculator.TestBytes, 0, CrcCalculator.TestBytes.length);
            if (result != calculator.Parameters.Check)
                out.println(calculator.Parameters.Name + " - BAD ALGO!!! " + Long.toHexString(result).toUpperCase());
        }
    }
}
