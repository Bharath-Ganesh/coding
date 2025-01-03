package com.practice.uiuc.greedy;

//https://leetcode.com/problems/lemonade-change/
public class LemonadeChange {

    public static void main(String[] args) {
        LemonadeChange obj = new LemonadeChange();
        int[] bills = {5,5,5,10,20};
        obj.lemonadeChange(bills);
    }

    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        int twenty = 0;
        int balance = 0;

        for(int i=0; i<bills.length; i++){
            int rupees = bills[i];
            int amountToBePaid = rupees - 5;
            if(amountToBePaid > balance){
                return false;
            }

            int denominationUsed;
            denominationUsed = deductChanges(twenty, 20, amountToBePaid);
            if(denominationUsed > 0){
                twenty-=denominationUsed;
                amountToBePaid = amountToBePaid - denominationUsed*20;
            }


            denominationUsed = deductChanges(ten, 10, amountToBePaid);
            if(denominationUsed > 0){
                ten-=denominationUsed;
                amountToBePaid = amountToBePaid - denominationUsed*10;
            }


            denominationUsed = deductChanges(five, 5, amountToBePaid);
            if(denominationUsed > 0) {
                five -= denominationUsed;
                amountToBePaid = amountToBePaid - denominationUsed * 5;
            }

            if(amountToBePaid!=0){
                return false;
            }
            if(rupees == 5){
                five++;
            }else if(rupees == 10){
                ten++;
            }else if(rupees == 20){
                twenty++;
            }
            balance += 5;
        }
        return true;
    }


    private int deductChanges(int denominationCount, int denominationValue, int amountToBePaid){
        int count = 0;
        while(denominationCount > 0 && amountToBePaid> 0 && amountToBePaid >= denominationValue){
            count+=1;
            amountToBePaid-=denominationValue;
            denominationCount--;
        }
        return count;
    }
}
