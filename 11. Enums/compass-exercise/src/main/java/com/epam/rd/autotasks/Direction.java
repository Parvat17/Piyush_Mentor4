package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    private int degrees;

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private static int normalizeDegrees(int degrees) {
        degrees = degrees % 360;
        if (degrees < 0) {
            degrees += 360;
        }
        return degrees;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = normalizeDegrees(degrees);
        for (Direction direction : Direction.values()) {
            if (direction.degrees == degrees) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = normalizeDegrees(degrees);
        Direction closestDirection = null;
        int minDifference = 360; // Maximum possible difference is 359
        for (Direction direction : Direction.values()) {
            int difference = Math.abs(direction.degrees - degrees);
            if (difference > 180) {
                difference = 360 - difference;
            }
            if (difference < minDifference) {
                minDifference = difference;
                closestDirection = direction;
            }
        }
        return closestDirection;
    }

    public Direction opposite() {
        int oppositeDegrees = normalizeDegrees(this.degrees + 180);
        return ofDegrees(oppositeDegrees);
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(this.degrees - direction.degrees);
        if (difference > 180) {
            difference = 360 - difference;
        }
        return difference;
    }
}
