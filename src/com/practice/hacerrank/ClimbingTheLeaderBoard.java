package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An arcade game player wants to climb to the top of the leaderboard and track
 * their ranking. The game uses Dense Ranking, so its leaderboard works like
 * this:
 * 
 * The player with the highest score is ranked number 1 on the leaderboard.
 * Players who have equal scores receive the same ranking number, and the next
 * player(s) receive the immediately following ranking number.
 * 
 * ranked = new ArrayList<>(Arrays.asList(100 ,100 ,50, 40, 40, 20, 10));
 * 
 * player = new ArrayList<>(Arrays.asList(5 ,25, 50, 120));
 * 
 * Output : 6, 4, 2, 1
 */
public class ClimbingTheLeaderBoard {

	public static void main(String[] args) {
		List<Integer> ranked = new ArrayList<>(Arrays.asList(100, 100, 50, 40, 40, 20, 10));
		List<Integer> player = new ArrayList<>(Arrays.asList(5, 25, 50, 120));
		List<Integer> result = climbingTheLeaderBoard(ranked, player);
		System.out.println(result.stream().collect(Collectors.toList()));

	}

	/**
	 * O(n^2)
	 */
	private static List<Integer> climbingTheLeaderBoard(List<Integer> ranked, List<Integer> player) {
		List<Integer> result = new ArrayList<>();
		int rank[] = new int[ranked.size()];
		rank[0] = 1;
		for (int i = 1; i < ranked.size(); i++) {
			if (ranked.get(i - 1) > ranked.get(i)) {
				rank[i] = rank[i - 1] + 1;
			} else {
				rank[i] = rank[i - 1];
			}
		}

		for (int i = 0; i < player.size(); i++) {
			int playerScore = player.get(i);
			if (ranked.get(0) <= playerScore) {
				result.add(1);
			} else if (ranked.get(ranked.size() - 1) > playerScore) {
				result.add(rank[rank.length - 1] + 1);
			} else {
				int index = binarySearch(ranked, playerScore);
				result.add(rank[index]);
			}
		}

		return result;
	}

	private static int binarySearch(List<Integer> ranked, int playerScore) {

		int low_index = 0;
		int high_index = ranked.size() - 1;

		while (low_index <= high_index) {
			int mid = (low_index + high_index) / 2;
			if (ranked.get(mid) == playerScore) {
				return mid;
			} else if (ranked.get(mid) < playerScore && ranked.get(mid - 1) > playerScore) {
				return mid;
			} else if (ranked.get(mid) > playerScore && ranked.get(mid + 1) < playerScore) {
				return mid + 1;
			} else if (ranked.get(mid) < playerScore) {
				high_index = high_index - 1;
			} else if (ranked.get(mid) > playerScore) {
				low_index = low_index + 1;
			}
		}

		return -1;
	}

}
