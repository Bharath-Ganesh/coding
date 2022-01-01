package com.leetcode.dp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSample {
    public static void main(String[] args) {
        String url = "https://scontent.xx.fbcdn.net/v/t1.15752-9/280209397_745338903303583_3780883544740627529_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=58c789&_nc_ohc=zcbbsjFDkuwAX8hi-uX&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AVLOf-oP-TFnkV_NoLF3CD3gzmwvAbnoNHAWGBHLuwrbMA&oe=62AB6033";
        String regex = "[^/\\\\&\\?]+\\.\\w{3,4}(?=([\\?&].*$|$))";
        Pattern p = Pattern.compile(regex);//. represents single character
        Matcher matcher = p.matcher(url);
        int count=0;
        while(matcher.find()){
            System.out.println(matcher.group(count));
        }

    }
}
