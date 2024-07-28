package com.epam.rd.qa.classes;

import java.util.Random;

public class ArrayRectangles {

    Rectangle[] rectangles;
    int index = 0;
    int size;
    double currentMaxArea = Double.MIN_VALUE;
    int maxIndex = 0;
    double minPerimeter = Double.MAX_VALUE;
    int minIndex = 0;
    int counter=0;
    public ArrayRectangles(int size) {
        // TODO place your code here
        this.size = size;
        if(size <= 0) throw new IllegalArgumentException();
        rectangles = new Rectangle[size];

    }

    public void calculateValues(Rectangle rectangle)
    {
        if(rectangle.area() > currentMaxArea)
        {
            currentMaxArea = rectangle.area();
            maxIndex = index;
        }
        if(rectangle.perimeter() < minPerimeter)
        {
            minPerimeter = rectangle.perimeter();
            minIndex = index;
        }
        if(rectangle.isSquare())
        {
            counter++;
        }
        index++;
    }

    public ArrayRectangles(Rectangle... rectangles) {
        if(rectangles == null || rectangles.length == 0) throw new IllegalArgumentException();
        this.rectangles = rectangles;
        for(Rectangle x : rectangles)
        {
//            System.out.println(x.area());
            calculateValues(x);
        }
    }

    public boolean addRectangle(Rectangle rectangle) {
        // TODO place your code here
        if(index >= size || rectangle == null) return false;
        rectangles[index] = rectangle;
        calculateValues(rectangle);
        return true;
    }

    public int size() {
        return index;
    }

    public int indexMaxArea() {
        // TODO place your code here
        return maxIndex;
    }

    public int indexMinPerimeter() {
        // TODO place your code here
        return minIndex;
    }

    public int numberSquares() {
        // TODO place your code here
        return counter;
    }

    public static void main(String[] args) {
        ArrayRectangles recs = new ArrayRectangles(10);
        ArrayRectangles recs2 = new ArrayRectangles(new Rectangle(11,2),
                new Rectangle(2999,9));
        Rectangle rec1 = new Rectangle(1000,12);
        recs.addRectangle(rec1);
        recs.addRectangle(new Rectangle(133,2));
//        System.out.println(recs.indexMaxArea());
//        System.out.println(recs.currentMaxArea);
        System.out.println(recs2.indexMaxArea());
        System.out.println(recs2.indexMinPerimeter());
    }
}
