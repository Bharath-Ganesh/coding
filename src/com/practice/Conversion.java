package com.practice;

/**
 * A teacher asks the class to open their books to a page number. A student can
 * either start turning pages from the front of the book or from the back of the
 * book. They always turn pages one at a time. When they open the book, page is
 * always on the right side:
 * 
 * When they flip page 1, they see pages 2 and 3. Each page except the last page
 * will always be printed on both sides. The last page may only be printed on
 * the front, given the length of the book. If the book is n pages long, and a
 * student wants to turn to page p, what is the minimum number of pages to turn?
 * They can start at the beginning or the end of the book.
 * 
 * Given n and p, find and print the minimum number of pages that must be turned
 * in order to arrive at page p.
 * 
 * if n=5 ; p=3;
 *
 */
public class Conversion {

	public static void main(String[] args) {
		int minTurn = pageCount(12, 4);
		System.out.println(minTurn);

	}

	/*
	 * O(1)
	 */
	private static int pageCount(int numberOfPages, int page) {
		int pageCount = 0;
		int pageTurnFront = page / 2;
		int totalPageTurn = numberOfPages / 2;

		// number of pages turn from the end = totalPageTurn -pageTurnFront ;
		pageCount = totalPageTurn - pageTurnFront > pageTurnFront ? pageTurnFront : totalPageTurn - pageTurnFront;
		return pageCount;
	}

	/*
	 * O(1)
	 */
	public static int pageCountInitial(int n, int p) {
		// Write your code here

		int pagesTurnFront = 0;
		int pagesTurnEnd = 0;
		// Total page count from front
		pagesTurnFront = (p) / 2;
		// from end
		pagesTurnEnd = ((n - p)) / 2;

		// if it's even he has to turn one more page
		if (n % 2 == 0)
			pagesTurnEnd += 1;

		int minTurn = (pagesTurnEnd > pagesTurnFront) ? pagesTurnFront : pagesTurnEnd;

		return minTurn;

	}

}
