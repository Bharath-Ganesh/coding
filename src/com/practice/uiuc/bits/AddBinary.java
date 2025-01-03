package com.practice.uiuc.bits;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        String a = "1010", b = "1011";
        System.out.println(obj.addBinary(a, b));
    }

    public String addBinary(String a, String b) {


        int carry = 0;

        int ind1 = a.length() - 1;
        int ind2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while(ind1 >= 0 || ind2 >= 0){

            int sum1 = ind1 < 0 ? 0: Integer.parseInt(a.charAt(ind1)+ "");
            int sum2 = ind2 < 0 ? 0: Integer.parseInt(b.charAt(ind2)+ "");
            carry = carry + sum1 + sum2;
            res.append(carry%2);
            carry = carry/2;

            ind1--;ind2--;
        }
        if(carry > 0){
            res.append(carry%2);
        }

        return res.reverse().toString();
    }
}
