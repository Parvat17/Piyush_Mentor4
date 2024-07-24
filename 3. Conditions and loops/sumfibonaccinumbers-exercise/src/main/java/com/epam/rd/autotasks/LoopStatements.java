package com.epam.rd.autotasks;

import java.util.*;
class LoopStatements {
    public static int sumOfFibonacciNumbers(int n)
    {
        int i,a=0,b=1,c,sum=0;
        if(n < 0) throw  new IllegalArgumentException();
        if(n == 0)
        {
            return 0;
        }
        else{
            for (i=1;i<n;i++)
            {
                sum=sum+b;
                c=b+a;
                a=b;
                b=c;
            }
            return sum;

        }
    }
}