package com.practice.pepcoding.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class NormalQueueBuild {

	public static void main(String[] args) {
		Queue<Integer> normalQueue = new ArrayDeque<>();
		normalQueue.add(20);
		normalQueue.add(30);
		normalQueue.add(40);
		normalQueue.remove();
		normalQueue.remove();
		normalQueue.remove();
		normalQueue.add(50);
		normalQueue.add(60);
		normalQueue.add(70);
		normalQueue.add(80);
		normalQueue.add(90);
		
		
		while(normalQueue.size()!=0) {
			System.out.println(normalQueue.remove());
		}

	}

}
