package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an itenary of an user, find the route map of the user
 * <p>
 * CHENNAI 	-> BANGALORE
 * BOMBAY	-> DELHI
 * GOA		-> CHENNAI
 * DELHI	-> GOA
 * <p>
 * BOMBAY -> DELHI -> GOA -> CHENNAI -> BANGALORE
 */

public class _001_FindIternary {

    public static void main(String[] args) {

        Map<String, String> sourceAndDestination = new HashMap<>();

        sourceAndDestination.put("CHENNAI", "BANGALORE");
        sourceAndDestination.put("DELHI", "GOA");
        sourceAndDestination.put("GOA", "CHENNAI");
        sourceAndDestination.put("BOMBAY", "DELHI");
        String originalSource = findStartingPoint(sourceAndDestination);
        System.out.println(originalSource);
        findRoute(sourceAndDestination, originalSource);

    }

    private static void findRoute(Map<String, String> sourceAndDestination, String originalSource) {

        if(sourceAndDestination.containsKey(originalSource)){
            System.out.printf(originalSource+ " -> ");
            findRoute(sourceAndDestination,sourceAndDestination.get(originalSource));
        }else{
            System.out.printf(originalSource+ ".");
        }
    }

    private static String findStartingPoint(Map<String, String> sourceAndDestination) {

        String startingPoint = "";
        Map<String, Boolean> potentialSource = new HashMap<>();
        for (String source : sourceAndDestination.keySet()) {
            String destination = sourceAndDestination.get(source);
            potentialSource.put(destination, false);
            if (!potentialSource.getOrDefault(source, true).equals(false)) {
                potentialSource.put(source, true);
            }
        }

        for (String source : potentialSource.keySet()) {
            if (potentialSource.get(source).equals(true)) {
                startingPoint = source;
                break;
            }
        }
        return startingPoint;
    }

//	private static void findRoute(Map<String, String> sourceAndDestination, String originalSource) {
//
//		boolean loopFlag = true;
//		while (loopFlag) {
//			if (sourceAndDestination.containsKey(originalSource)) {
//				System.out.print(originalSource + " -> ");
//				originalSource = sourceAndDestination.get(originalSource);
//			} else {
//				System.out.println(originalSource + " .");
//				loopFlag = false;
//			}
//		}

}
