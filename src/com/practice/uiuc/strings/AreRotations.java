package com.practice.uiuc.strings;

public class AreRotations {

    public static void main(String[] args) {
        AreRotations obj = new AreRotations();
        String s1 = "ihnrttglscetrrvnndlluaoabkessickbafwqimwuddmlbrzbzdevilnhslqtfdvtdugcterwfpkvlwsgwvfnhsozxpatqdkagkczzhxvxmitvrtnmftbguzuekototgnjbfiqjfojjgdrtriuiflcsnfcrlrofxwkmowimvdjklbkxoetrdhqznyxhrncfiltxhoxbmqlsnepzuwxojtqbypucxiauhcqotslwxdpcnjuwdtpgttphmjhohjoutihpypqwgdqpylrrdvvtwnzyjwwpyvoztxyvbpfmbkkbnqntroumpzzfaswmjluioknldxidrcvqxrgilziohwbjeyfbhwtmctycrmtzlyacxvccoewloalyrgpsyzxz" ;
        String s2 = "otgnjbfiqjfojjgdrtriuiflcsnfcrlrofxwkmowimvdjklbkxoetrdhqznyxhrncfiltxhoxbmqlsnepzuwxojtqbypucxiauhcqotslwxdpcnjuwdtpgttphmjhohjoutihpypqwgdqpylrrdvvtwnzyjwwpyvoztxyvbpfmbkkbnqntroumpzzfaswmjluioknldxidrcvqxrgilziohwbjeyfbhwtmctycrmtzlyacxvccoewloalyrgpsyzxzihnrttglscetrrvnndlluaoabkessickbafwqimwuddmlbrzbzdevilnhslqtfdvtdugcterwfpkvlwsgwvfnhsozxpatqdkagkczzhxvxmitvrtnmftbguzuekot";
        obj.areRotations(s1, s2);
    }

    public static boolean areRotations(String s1, String s2 )
    {
        // Your code here

        int n1 = s1.length();
        int n2 = s2.length();

        if(n1!=n2) return false;

        int rotations = 2;
        int index = 0;
        int left = 0;
        while(rotations > 0){

            if(s1.charAt(index) == s2.charAt(left)){
                left++;
            }else {
                left = 0;
            }
            index ++;
            if(left == n1) return true;
            if(index == n1){
                index = 0;
                rotations--;
            }
        }
        return false;
    }
}
