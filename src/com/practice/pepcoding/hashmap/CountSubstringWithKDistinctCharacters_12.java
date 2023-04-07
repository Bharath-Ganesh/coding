package com.practice.pepcoding.hashmap;


import java.util.HashMap;
import java.util.Map;

/**
 * Find the number of substrings having exactly k distinct characters in O(n) times
 * String expression = "abcabdabbcfa"
 * int k=3
 * <p>
 * OUTPUT
 * <p> : 19
 * abc abca abcab bca bcab cab abd abda abdab abdabb bda bdab bdabb dab dabb abbc bbcf bcf cfa
 */

public class CountSubstringWithKDistinctCharacters_12 {

    public static void main(String[] args) {
        String expression = "abcabdabbcfa";
        int k = 3;
        int count = countSubstringWithKDistinctCharacters(expression, k);
        System.out.println(count);

    }


    private static void removeCharacterFromMap(Map<Character, Integer> map, Character ch) {
        if (map.get(ch) == 1) {
            map.remove(ch);
        } else {
            map.put(ch, map.get(ch) - 1);
        }
    }

    private static int countSubstringWithKDistinctCharacters(String expression, int k) {


        int count = 0;

        Map<Character, Integer> bigMap = new HashMap<>();
        Map<Character, Integer> smallMap = new HashMap<>();

        //window acquire
        int smallI = -1;
        int bigI = -1;

        //release
        int j = -1;

        // k==1
        if (k == 1) {
            return countSubstringWithKDistinctCharactersForKOne(expression);
        }

        while (true) {
            boolean flag1 = true;
            boolean flag2 = true;
            boolean flag3 = true;

            while (bigI < expression.length() - 1) {
                flag1 = false;
                bigI++;
                Character ch = expression.charAt(bigI);
                bigMap.put(ch, bigMap.getOrDefault(ch, 0) + 1);
                if (bigMap.size() == (k + 1)) {
                    removeCharacterFromMap(bigMap, ch);
                    bigI--;
                    break;
                }
            }

            while (smallI < bigI) {
                flag2 = false;
                smallI++;
                Character ch = expression.charAt(smallI);
                smallMap.put(ch, smallMap.getOrDefault(ch, 0) + 1);
                if (smallMap.size() == (k)) {
                    removeCharacterFromMap(smallMap, ch);
                    smallI--;
                    break;
                }
            }

            while (j < smallI) {

                if (bigMap.size() == k && smallMap.size() == k - 1) {
                    count += bigI - smallI;
                } else {
                    break;
                }
                flag3 = false;
                j++;
                Character ch = expression.charAt(j);
                removeCharacterFromMap(smallMap, ch);
                removeCharacterFromMap(bigMap, ch);
            }


            if (flag1 && flag2 && flag3) {
                break;
            }
        }

        return count;
    }

    private static int countSubstringWithKDistinctCharactersForKOne(String expression) {

        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean flag1 = true;
            boolean flag2 = true;
            while (i < expression.length() - 1) {
                flag1 = false;
                i++;
                Character ch = expression.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == 2) {
                    i--;
                    removeCharacterFromMap(map, ch);
                    break;
                }
            }

            while (j < i) {
                flag2 = false;
                if (map.size() == 1) {
                    count += (i - j);
                }
                j++;
                Character ch = expression.charAt(j);
                removeCharacterFromMap(map, ch);
                if (map.size() == 0) {
                    break;
                }
            }

            if (flag1 && flag2) {
                break;
            }
        }
        return count;
    }


}



