package com.epam.rd.autotasks;

import java.rmi.UnexpectedException;

class ConditionStatements {
    public static int task1(int n) {
        //TODO: Delete line below and write your own solution

        if(n>0)
        {
            return (int)Math.pow(n,2);
        }
        if(n==0)
        {
            return 0;
        }
        else {
            return (n*(-1));
        }

    }


}
