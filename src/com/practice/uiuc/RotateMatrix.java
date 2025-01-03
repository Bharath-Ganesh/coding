package com.practice.uiuc;

public class RotateMatrix {

    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        obj.rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }

    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int left=0, top = 0;
        int right=n-1, bottom = n-1;

        while(left < right){

            for(int i=0; i< (right-left); i++){
                int topLeft = matrix[top+i][left];
                matrix[top+i][left] = matrix[bottom][left+i];
                matrix[bottom][left+i] = matrix[bottom-i][right];
                matrix[bottom-i][right] = matrix[top][right-i];
                matrix[top][right-i] = topLeft;
            }
            top++;bottom--;
            right--;left++;
        }
    }
}
