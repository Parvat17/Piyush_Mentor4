package com.epam.rd.autotasks;

import java.util.Arrays;

public class FunctionsTask2 {
    public static boolean isSorted(int[] array, SortOrder order) {
        //TODO: Delete line below and write your own solution

        if(array==null)
            throw new IllegalArgumentException();
        if(array.length<=0)
            throw new IllegalArgumentException();
        if(array.length==1)
        {
            return true;
        }
        else
        {
            if(order == SortOrder.ASC)
            {
                for(int i=0;i<array.length-1;i++)
            {
                if(array[i]>array[i+1])
                {
                    return false;
                }
            }
            }

            if(order == SortOrder.DESC)
            {
                for(int i=0;i<array.length-1;i++)
                {
                    if(array[i]<array[i+1])
                    {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static int[] transform(int[] array, SortOrder order) {
        //TODO: Delete line below and write your own solution

        boolean bool = isSorted( array, order);


            if (bool) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] + i;
                }
            } else
                return array;


        return array;
    }
}
