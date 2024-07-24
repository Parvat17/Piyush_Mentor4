package com.epam.rd.autotasks.meetautocode;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        String h,m,s;
        s=Integer.toString(seconds%60);
        seconds=seconds/60;
        while(s.length()==1)
        {
            s=0+s;
        }
        m=Integer.toString(seconds%60);
        seconds=seconds/60;
        while(m.length()==1)
        {
            m=0+m;
        }
        h=Integer.toString(seconds%24);
        System.out.println(h + ":" + m + ":" + s);


    }
}


