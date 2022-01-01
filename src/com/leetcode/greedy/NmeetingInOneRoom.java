package com.leetcode.greedy;

import java.util.*;

class Pair {

    int start;
    int end;
    int meetingId;

    public Pair(int start, int end, int meetingId) {
        this.start = start;
        this.end = end;
        this.meetingId = meetingId;
    }
}

public class NmeetingInOneRoom {

    public static void main(String[] args) {
        int start[] = {10,12,20};
        int end[] = {25,20,30};
        System.out.println(maxMeetings(start, end, end.length));
    }


    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(start[i], end[i], i + 1));
        }

        Comparator<Pair> comparator = (p1, p2) -> {
            if (p1.end > p2.end) {
                return 1;
            } else if (p1.end < p2.end) {
                return -1;
            } else if (p1.meetingId > p2.meetingId) {
                return 1;
            }
            return -1;
        };
        Collections.sort(pairs, comparator);

        int maxMeeting = 1;
        int endTime = pairs.get(0).end;

        for (int i = 1; i < n; i++) {
            Pair p = pairs.get(i);
            if (p.start > endTime) {
                maxMeeting += 1;
                endTime = p.end;
            }
        }
        return maxMeeting;
    }
}
