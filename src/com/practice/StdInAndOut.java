package com.practice;

import java.util.*;

public class StdInAndOut {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");
		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);
		String[] magazine = new String[m];
		String[] magazineItems = scanner.nextLine().split(" ");
		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}
		String[] note = new String[n];
		String[] noteItems = scanner.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}
		scanner.close();
	}

}
