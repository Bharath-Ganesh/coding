package com.practice.uiuc.bits;

public class CopySetBits {

    public static void main(String[] args) {
        CopySetBits copySetBits = new CopySetBits();
        System.out.println(copySetBits.setBit(44, 3, 1, 5));
    }


     int setBit(int x, int y, int l, int r){
        // code here

        int range = r - l;
        int mask  = 1 << (range + 1);
        mask = mask - 1;

        mask = mask << (l - 1);

        return x | mask;
    }
}
