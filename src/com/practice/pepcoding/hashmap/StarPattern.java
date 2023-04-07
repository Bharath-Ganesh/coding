package com.practice.pepcoding.hashmap;

/**

           *                 *
         *   *             *    *
       *       *         *        *
     *           *     *            *
   *               * *                *


 0123*012345678*012345678*
 012*&*0123456*&*0123456*&*
 01*&&&*01234*&&&*01234*&&&*
 0*&&&&&*012*&&&&&*012*&&&&&*
 *&&&&&&&*0*&&&&&&&*0*&&&&&&&*
 */
public class StarPattern {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int rows=sc.nextInt();
//        int moutains=sc.nextInt();
        int rows=5;
      //  printOneMountain(rows);
        printNMountains(5,3,0);
    }

    private static void printOneMountain(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < (2 * rows); j++) {
                int starPos = rows - i;
                int nextStar = (2 * rows - starPos);
                if (nextStar == j || starPos == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void printNMountains(int rows,int n,int i){
        if(rows==0)
            return;
        for (int z=1;z<=n;z++){
            int cond=z<=2? z:2;
            for (int k=0;k< cond*rows-1;k++){
                System.out.print(k);
            }
            System.out.print("*");

            for (int j = 0; j<(2*i); j++) {
                if(j== 2*i-1){
                    System.out.print("*");
                }else{
                    System.out.print("&");
                }
            }
        }
        System.out.println("");
        printNMountains(rows-1,n,i+1);
    }
}
