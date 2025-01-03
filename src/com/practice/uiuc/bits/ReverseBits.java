package com.practice.uiuc.bits;

public class ReverseBits {

    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();
        int n = 43261596;
        int num = obj.reverseBits(n);
        System.out.println(num);
    }

    public int reverseBits(int n) {

        int reverseBit  = 0;
        for(int i = 0; i < 32; i++){
            int bit = (n >> i) & 1;
            reverseBit = reverseBit | (bit  << (31 - i));
        }
        return reverseBit;
    }
}
