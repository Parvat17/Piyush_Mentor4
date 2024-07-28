package com.epam.rd.qa.classes;

public class Rectangle {
   private double sideA,sideB;

    Rectangle(double a, double b)
   {
       if(a <= 0.0 || b <= 0.0) throw new IllegalArgumentException();
       sideA = a;
       sideB = b;
   }
   Rectangle(double a)
   {
       if(a <= 0.0) throw new IllegalArgumentException();
       sideA = sideB = a;
   }
   Rectangle()
   {
       sideA = 4.00;
       sideB = 3.00;
   }

   public double getSideA()
   {
       return sideA;
   }


    public double getSideB() {
        return sideB;
    }

    public double area()
    {
        return sideA * sideB;
    }
    public double perimeter()
    {
        return 2.00*(sideA + sideB);
    }
    public boolean isSquare()
    {
        return sideA == sideB;
    }
    public void replaceSides()
    {
        sideA = sideA + sideB;
        sideB = sideA - sideB;
        sideA = sideA - sideB;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        Rectangle recObj = (Rectangle) obj;
        return (this.sideB == recObj.sideB) && this.sideA == recObj.sideA;
    }

    @Override
    public int hashCode()
    {

        return 7* (int)sideA + 13*(int)sideB;
    }


}
