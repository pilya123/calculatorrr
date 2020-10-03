package bin.hex.calculator1.math;

import java.util.Arrays;

import bin.hex.calculator1.util.Log;

@SuppressWarnings("serial")
class EndianConvert {

    static String convert(String initial, boolean little) {
        String toConvert = no0x(initial.replaceAll("[\\s+\\,\\.]", ""));
        if (little) {
            String[] reverse = new String[toConvert.length() / 2];
            int j = 0;

            /**
             * Take the input, group it into pairs, and initialise
             * into the String array previously made
             * */
            for (int i = 0; i < toConvert.length() / 2; i++) {
                reverse[i] = toConvert.substring(j, j + 2);
                j += 2;
            }

            /**
             * Take the array, reverse, convert to String, then add "0x"
             * in front of it
             * */
            String reversed = "0x" + reverseArray(reverse);
            Log.log("Little Endian converted: " + reversed);
            return reversed;

        }
        String bigEndian = "0x" + toConvert;
        Log.log("Big Endian converted: " + toConvert);
        return bigEndian;

    }

    /**
     * @param remove
     * @return String without "0x" or "0X" in the beginning
     */
    private static String no0x(String remove) {
        if (remove.substring(0, 2).equals("0x") || remove.substring(0, 2).equals("0X")) {
            remove = remove.substring(2, remove.length());
        }
        return remove;
    }

    /**
     * @param reverse
     * @return String who was converted from a String array with its indexes reversed
     */
    private static String reverseArray(String[] reverse) {
        for (int i = 0; i < reverse.length / 2; i++) {
            String temp = reverse[i];
            reverse[i] = reverse[reverse.length - 1 - i];
            reverse[reverse.length - 1 - i] = temp;
        }
        return Arrays.toString(reverse).replaceAll("[\\s+\\,\\[\\]]", "");
    }
}
