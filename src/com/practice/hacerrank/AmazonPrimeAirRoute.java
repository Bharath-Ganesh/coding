package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonPrimeAirRoute {

	public static void main(String[] args) {
		int maxTravelDist = 10000;
		List<List<Integer>> forwardRouteList = new ArrayList<>(Arrays.asList(Arrays.asList(1, 3000),
				Arrays.asList(2, 8000), Arrays.asList(3, 7000), Arrays.asList(4, 10000)));
		List<List<Integer>> returnRouteList = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2000),
				Arrays.asList(2, 3000), Arrays.asList(3, 4000), Arrays.asList(4, 5000)));
		List<List<Integer>> routeList = routePairs(maxTravelDist, forwardRouteList, returnRouteList);
		System.out.println(routeList);
	}

	public static List<List<Integer>> routePairs(int maxTravelDist, List<List<Integer>> forwardRouteList,
			List<List<Integer>> returnRouteList) {
		List<List<Integer>> routeList = new ArrayList<>();

		int forwardIndex = 0;
		int returnIndex = returnRouteList.size() - 1;
		int optimalDistance = 0;
		while (forwardIndex < forwardRouteList.size() && returnIndex >= 0) {
			List<Integer> forwardRoute = forwardRouteList.get(forwardIndex);
			List<Integer> returnRoute = returnRouteList.get(returnIndex);
			int distance = forwardRoute.get(1) + returnRoute.get(1);

			if (distance <= maxTravelDist)
				forwardIndex++;
			else
				returnIndex--;

			if (optimalDistance <= distance && distance <= maxTravelDist) {
				List<Integer> route = new ArrayList<>();
				route.add(forwardRoute.get(0));
				route.add(returnRoute.get(0));
				if (routeList.isEmpty()) {
					routeList.add(route);
				} else {
					if (optimalDistance != distance) {
						routeList.remove(0);
					}
					routeList.add(route);
				}
				optimalDistance = distance;
			}
		}

		return routeList;

	}

}
