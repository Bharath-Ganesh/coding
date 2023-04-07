package com.leetcode.array;

/**
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns 3 possible results:
 *
 * -1: The number I picked is lower than your guess (i.e. pick < num).
 * 1: The number I picked is higher than your guess (i.e. pick > num).
 * 0: The number I picked is equal to your guess (i.e. pick == num).
 * Return the number that I picked.
 */
public class GuessNumber_26 {

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2,3};
        System.out.println(guessNumber(10));
    }

    public static int guessNumber(int n) {

        int start=1;
        int end=n;
        while(start<end){
            int mid=(end-start)/2+start;
            int gs=guess(mid);
            if(gs==0){
                end=mid;
                break;
            }else if(gs==-1){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return end;
    }

    private static int guess(int mid) {
        if(mid==6)
            return 0;
        else if(mid>=1 && mid<6){
            return 1;
        }else {
            return -1;
        }
    }


}
