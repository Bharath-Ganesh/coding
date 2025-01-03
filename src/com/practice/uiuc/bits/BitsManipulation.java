package com.practice.uiuc.bits;

public class BitsManipulation {

    public static void main(String[] args) {
        BitsManipulation obj = new BitsManipulation();
        int num = 113;
        int k = 4;
        System.out.println("\n******* clearKthBit *******\n");
        obj.clearKthBit(num, k);
        System.out.println("\n******* CountSetBits *******\n");
        obj.countSetBits(num);
    }

    private void countSetBits(int num) {
        int n = num;
        int counter = 0;
        while(num!=0){
            num = num & (num -1);
            counter++;
        }
        System.out.println("Number             "  + Integer.toBinaryString(n));
        System.out.println("Set Bits           "  + counter);
    }

    private void clearKthBit(int num, int k) {
        String s = Integer.toBinaryString(num);
        System.out.println("num                " + s);

        int setRightMostBit = num & (num - 1);
        System.out.println("setRightMostBit    " + Integer.toBinaryString(setRightMostBit));

        int x = 1;
        System.out.println("x                  " + Integer.toBinaryString(x));
        x = x << k;
        System.out.println("x << " + k + "             " + Integer.toBinaryString(x));
        System.out.println("~x                 " + Integer.toBinaryString(~x));
        int clearKthBit = num & ~x;
        System.out.println("clearKthBit        " + Integer.toBinaryString(clearKthBit));
    }


    public String convertIntegerToBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder binaryNumber = new StringBuilder();
        while (n > 0) {
            int remainder = n % 2;
            binaryNumber.append(remainder);
            n /= 2;
        }
        binaryNumber = binaryNumber.reverse();
        return binaryNumber.toString();
    }
}
