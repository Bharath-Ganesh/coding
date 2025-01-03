package com.practice.uiuc.bits;

public class CheckIfPowerOf2 {

    public static void main(String[] args) {
        CheckIfPowerOf2 obj = new CheckIfPowerOf2();
        int num = 1;
        System.out.println(obj.checkIfPowerOf2(num));
    }

    private boolean checkIfPowerOf2(int num) {

        int val = num & (num - 1);
        return val == 0?true:false;
    }
}
