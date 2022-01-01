package com.leetcode.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();
        int n1 = 4, src1 = 0, dst1 = 3, k1 = 1;
        int[][] flights1 = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        int n2 = 3, src2 = 1, dst2 = 2, k2 = 1;
        int[][] flights2 = {{0, 1, 2}, {1, 2, 1}, {2, 0, 10}};


        int n = 5, src = 0, dst = 2, k = 2;
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};

        int cheapestPrice = obj.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(cheapestPrice);
    }

    class Flight {

        int distance;
        int node;
        int stops;

        public Flight(int distance, int node, int stops) {
            this.distance = distance;
            this.node = node;
            this.stops = stops;
        }
    }

    class Pair {


        int edgeWeight;
        int v;

        public Pair(int edgeWeight, int v) {
            this.edgeWeight = edgeWeight;
            this.v = v;

        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> graph = new ArrayList<>();

        //Construct a graph
        for (int node = 0; node < n; node++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int edgeWeight = flights[i][2];
            graph.get(u).add(new Pair(edgeWeight, v));
        }


        int[] distance = new int[n];
        Arrays.fill(distance, (int) 1e9);
        distance[src] = 0;


        Queue<Flight> pq = new LinkedList<>();
        pq.add(new Flight(0, src, 0));

        while (!pq.isEmpty()) {
            Flight p = pq.remove();
            int dist = p.distance;
            int u = p.node;
            int stops = p.stops;

            if (stops > k) {
                continue;
            }

            for (Pair adjNode : graph.get(u)) {
                int edgeWeight = adjNode.edgeWeight;
                int v = adjNode.v;

                if (dist + edgeWeight < distance[v] && stops<=k) {
                    distance[v] = dist + edgeWeight;
                    pq.add(new Flight(distance[v], v, stops + 1));
                }
            }

        }
        return distance[dst] == (int) 1e9 ? -1 : distance[dst];
    }
}
