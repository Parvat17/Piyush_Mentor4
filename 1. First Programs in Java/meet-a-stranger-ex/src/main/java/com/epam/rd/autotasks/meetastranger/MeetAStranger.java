package com.epam.rd.autotasks.meetastranger;
import java.util.*;
public class MeetAStranger {
    public static void main(String[] args) {
        //Write a program, which read a String from System.in and print "Hello, <input string>"
        Scanner in = new Scanner(System.in);
        {
            String str;
            str = in.nextLine();
            System.out.println("Hello, "+str);
        }
    }
}
