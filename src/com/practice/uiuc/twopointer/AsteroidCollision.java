package com.practice.uiuc.twopointer;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        AsteroidCollision obj = new AsteroidCollision();
        int[] res = new int[] { -2,-1,1,2 };
        System.out.println(obj.asteroidCollision(res));
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        int n = asteroids.length;
        for (int i = 0; i < n; i++) {
            int element = asteroids[i];
            if(element > 0) stack.push(asteroids[i]);
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(element) > stack.peek()){
                    stack.pop();
                }
                if(!stack.isEmpty() && Math.abs(element) == stack.peek()) stack.pop();
                else if(stack.isEmpty() || stack.peek() < 0) stack.push(element);
            }
        }

        int[] result = new int[stack.size()];
        int count = stack.size();
        while (!stack.isEmpty()) {
            result[--count] = stack.pop();
        }
        return result;
    }
}
