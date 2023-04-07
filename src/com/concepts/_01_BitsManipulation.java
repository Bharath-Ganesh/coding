package com.concepts;

/**
 * You are given a number n , for example 25 = (11001) then
 * 1.  Set the 2nd bit                         (11101) = 29
 * 2.  Unset the 3rd bit                       (10001)= 17
 * 3.  Toggle the 3rd bit                      (10001)= 17
 * 4.  Check if 3rd Bit is set or not           Set
 */
public class _01_BitsManipulation {

    public static void main(String[] args) {
        setBit(25,2);
        unSetBit(25,3);
        toggleBit(25,3);
        checkIfBitIsOnOrOff(25,0);
        numberComplement(5);
        rightMostSetBitMask(58);
    }



    private static void setBit(int n,int index) {
        int onMask=1<<index;
        System.out.printf("SET BIT \n %d \n\n",(n | onMask));
    }

    private static void unSetBit(int n,int index) {
        int offMask= ~(1<<index);
        System.out.printf("UNSET BIT \n %d \n\n",(n & offMask));
    }

    private static void toggleBit(int n,int index) {
        int toggleMask= (1<<index);
        System.out.printf("TOGGLE BIT \n %d \n\n",(n ^ toggleMask));
    }

    private static void checkIfBitIsOnOrOff(int n,int index) {
        System.out.printf("CHECK BIT \n");
        int checkMask= (1<<index);
        System.out.println((n&checkMask)==0 ? "UNSET \n": "SET \n");

    }

    private static void numberComplement(int num) {
        int result=0;
        int shift=0;
        while (num>0){
            if((num&1)==0){
                result+= 1<<shift;
            }
            shift++;
            num>>=1;
        }
        System.out.printf("NUMBER COMPLEMENT \n %d \n\n",result);
    }

    // rsb = x & x's 2's complement
    private static void rightMostSetBitMask(int number) {
        int rsb=number&-number;
        System.out.println(Integer.toBinaryString(rsb));
    }

}
