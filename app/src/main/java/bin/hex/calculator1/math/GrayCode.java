package bin.hex.calculator1.math;

import java.util.ArrayList;

// Java program for Binary To Gray
// and Gray to Binary conversion
public class GrayCode {

    // Helper function to xor
    // two characters
    private static char xor_c(char a, char b)
    {
        return (a == b) ? '0' : '1';
    }

    // Helper function to flip the bit
    private static char flip(char c)
    {
        return (c == '0') ? '1' : '0';
    }

    // function to convert binary
    // string to gray string
    static String binaryToGray(String binary)
    {
        String gray = "";

        // MSB of gray code is same
        // as binary code
        gray += binary.charAt(0);

        // Compute remaining bits, next bit is
        // comuted by doing XOR of previous
        // and current in Binary
        for (int i = 1; i < binary.length(); i++) {
            // Concatenate XOR of previous bit
            // with current bit
            gray += xor_c(binary.charAt(i - 1),
                    binary.charAt(i));
        }

        return gray;
    }
    // function to convert gray code
    // string to binary string
    static String grayToBinary(String gray)
    {
        String binary = "";

        // MSB of binary code is same
        // as gray code
        binary += gray.charAt(0);

        // Compute remaining bits
        for (int i = 1; i < gray.length(); i++) {
            // If current bit is 0,
            // concatenate previous bit
            if (gray.charAt(i) == '0')
                binary += binary.charAt(i - 1);

                // Else, concatenate invert of
                // previous bit
            else
                binary += flip(binary.charAt(i - 1));
        }

        return binary;
    }

    // Driver program to test above functions
//    public static void main(String args[])
//    {
//        GrayCode ob = new GrayCode();
//        String binary = "01001";
//        System.out.println("Gray code of " + binary + " is " + GrayCode.binaryToGray(binary));
//
//        String gray = "01101";
//        System.out.println("Binary code of " + gray + " is " + GrayCode.grayToBinary(gray));
//    }

    // This function generates all n bit Gray codes and prints the
// generated codes
    public static String generateGrayarr(int n)
    {
        // base case
        if (n <= 0) {
            return "Input should not be <= 0. Actual: " + n;
        }

        // 'arr' will store all generated codes
        ArrayList<String> arr = new ArrayList<> ();

        // start with one-bit pattern
        arr.add("0");
        arr.add("1");

        // Every iteration of this loop generates 2*i codes from previously
        // generated i codes.
        int i, j;
        for (i = 2; i < (1<<n); i = i<<1)
        {
            // Enter the prviously generated codes again in arr[] in reverse
            // order. Nor arr[] has double number of codes.
            for (j = i-1 ; j >= 0 ; j--)
                arr.add(arr.get(j));

            // append 0 to the first half
            for (j = 0 ; j < i ; j++)
                arr.set(j, "0" + arr.get(j));

            // append 1 to the second half
            for (j = i ; j < 2*i ; j++)
                arr.set(j, "1" + arr.get(j));
        }

        // print contents of arr[]
        StringBuilder out = new StringBuilder();
        for (i = 0 ; i < arr.size() ; i++ ) {
            String code = arr.get(i);
            out.append(code);
            System.out.println(code);
        }
        return out.toString();
    }

    // Function to Generating N-bit
    // Gray Code starting from K
    public static String gray_K_of_N(int n, int k)
    {

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < (1 << n); i++)
        {
            // Generate gray code of corresponding
            // binary number of integer i.
            int x = i ^ (i >> 1) ^ k;
            String v = x + " ";
            out.append(v);
            System.out.print(out);
        }
        return out.toString();
    }
}

