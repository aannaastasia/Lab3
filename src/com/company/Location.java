package com.company;

import java.util.Objects;

/**
 * Этот класс представляет определенное место на 2D-карте.
 * Координаты являются целочисленными значениями.
 **/
public class Location {
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    /** Реализация метода equals () **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return xCoord == location.xCoord && yCoord == location.yCoord;
    }

    /** Реализация метода hashCode() **/
    @Override
    public int hashCode() {
        return Objects.hash(xCoord, yCoord);
    }
}
