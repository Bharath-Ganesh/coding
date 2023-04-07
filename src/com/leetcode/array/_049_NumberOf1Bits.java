package com.leetcode.array;

/**
 * 191. Number of 1 Bits
 * <p>
 * <p>
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * Note:
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type.
 * It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 * <p>
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * <p>
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */
public class _049_NumberOf1Bits {

    public static void main(String[] args) {
        int n = 521;
        System.out.println(hammingWeight(n));
    }

    /**
     * The binary representation of Integer.MAX_VALUE is 0111 1111 1111 1111 1111 1111 1111 1111, and
     * the binary representation of Integer.MAX_VALUE + 1 is 1000 0000 0000 0000 0000 0000 0000 0000 (spaces added).
     * Note that the leftmost bit here denotes the sign of the number, but recall that we're told to treat input as unsigned.
     * <p>
     * As mentioned above, Integer.MAX_VALUE is 2147483647, and Integer.MAX_VALUE + 1 is -2147483648.
     * <p>
     * Intuitively, we would agree that -2147483648 has 1 one.
     * <p>
     * However, if our test is n > 0, -2147483648 fails that test, so we don't count any 1s, and instead incorrectly return 0.
     * <p>
     * Why can't we use n >>= 1?
     * The assumption of this code is that, starting with a 32-bit binary number, we can move the bits over to the right, filling in zeros from the left.
     * <p>
     * So a few shifts of Integer.MAX_VALUE + 1 should look like this:
     * 0100 0000 0000 0000 0000 0000 0000 0000
     * 0010 0000 0000 0000 0000 0000 0000 0000
     * 0001 0000 0000 0000 0000 0000 0000 0000
     * <p>
     * The operation that describes that kind of shift is the unsigned shift (also "logical shift") operator, denoted by >>>.
     * <p>
     * The operation denoted by >> is indeed also a shift (the "signed" or "arithmetic" shift), but not the shift we're
     * looking for (since it fills in whatever the sign bit is, either 0 or 1)
     * <p>
     * A few shifts of Integer.MAX_VALUE + 1 using the >> operator would look like this:
     * 1100 0000 0000 0000 0000 0000 0000 0000
     * 1110 0000 0000 0000 0000 0000 0000 0000
     * 1111 0000 0000 0000 0000 0000 0000 0000
     * 1111 1000 0000 0000 0000 0000 0000 0000
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }


}