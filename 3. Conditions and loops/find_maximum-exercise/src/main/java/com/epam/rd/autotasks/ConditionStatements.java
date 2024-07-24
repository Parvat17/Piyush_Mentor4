package com.epam.rd.autotasks;
import java.util.*;
import java.rmi.UnexpectedException;

class ConditionStatements {

    public static int task2(int n) {
        int a,b,c,max=0,mid=0,min=0,n1=0;
        a=n%10;
        n/=10;
        b=n%10;
        n/=10;
        c=n%10;
        n/=10;
        mid=a+b+c;
        max = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
        min = c < (a < b ? a : b) ? c : ((a < b) ? a : b);
        mid=mid-max-min;
        n1=(max*100)+(mid*10)+min;
        return n1;
    }

}
