package com.epam.rd.autotasks.array;
import java.util.*;
public class IntArrayUtil {

	public static int maximumDistance(int[] array) {
		// TODO: Implement this method.
		if(array==null)
		{
			return 0;
		}
		int max;
		int i,j,c=0;
		if(array.length==0 || array.length==1)
			return 0;
		else
		{

			max=array[1];
			for (i = 0; i < array.length; i++)
			{
				for(j=1;j<array.length;j++)
				{
					if(max<array[j])
					{
						max=array[j];
					}

				}
			}

			for(i=0;i< array.length;i++)
			{
				if(array[i]==max)
				{
					for(j=i+1;j<array.length;j++)
					{
						if(array[j]==max)
						{
							c=j-i;


						}
					}
					break;
				}

			}

		}
		return c;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		{
			int[] array = null;
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] {};
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 4, 100, 3, 4 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 50, 50, 4, 5 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 5, 350, 350, 4, 350 };
			System.out.println("result = " + maximumDistance(array));
		}
		{
			int[] array = new int[] { 10, 10, 10, 10, 10 };
			System.out.println("result = " + maximumDistance(array));
		}
	}

}
