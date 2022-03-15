package com.company;
/**
 * Этот класс представляет собой простую двумерную карту, состоящую из квадратных ячеек.
 *  * Каждая ячейка указывает "стоимость" прохождения этой ячейки.
 **/
public class Map2D {
    /** Ширина карты.**/
    private int width;

    /** Высота карты. **/
    private int height;

    /**
     * Фактические данные карты, которые необходимы для навигации алгоритму поиска пути.
     **/
    private int[][] cells;

    /** The starting location for performing the A* pathfinding. **/
    private Location start;

    /** The ending location for performing the A* pathfinding. **/
    private Location finish;


    /** Creates a new 2D map, with the specified width and height. **/
    public Map2D(int width, int height)
    {
        if (width <= 0 || height <= 0)
        {
            throw new IllegalArgumentException(
                    "width and height must be positive values; got " + width +
                            "x" + height);
        }

        this.width = width;
        this.height = height;

        cells = new int[width][height];

        // Make up some coordinates for start and finish.
        start = new Location(0, height / 2);
        finish = new Location(width - 1, height / 2);
    }


    /**
     * Этот вспомогательный метод проверяет указанные координаты, чтобы убедиться,
     * что они в пределах карты. Если координаты не на карте
     *то метод генерирует исключение <code>IllegalArgumentException</code>.
     **/
    private void checkCoords(int x, int y)
    {
        if (x < 0 || x > width)
        {
            throw new IllegalArgumentException("x must be in range [0, " +
                    width + "), got " + x);
        }

        if (y < 0 || y > height)
        {
            throw new IllegalArgumentException("y must be in range [0, " +
                    height + "), got " + y);
        }
    }

    /** Returns the width of the map. **/
    public int getWidth()
    {
        return width;
    }

    /** Returns the height of the map. **/
    public int getHeight()
    {
        return height;
    }

    /**
     * Возвращает true, если указанные координаты содержатся на карте.
     **/
    public boolean contains(int x, int y)
    {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }


    /** Возвращает true, если местоположение содержится в области карты.. **/
    public boolean contains(Location loc)
    {
        return contains(loc.xCoord, loc.yCoord);
    }

    /** Returns the stored cost value for the specified cell. **/
    public int getCellValue(int x, int y)
    {
        checkCoords(x, y);
        return cells[x][y];
    }

    /** Returns the stored cost value for the specified cell. **/
    public int getCellValue(Location loc)
    {
        return getCellValue(loc.xCoord, loc.yCoord);
    }

    /** Sets the cost value for the specified cell. **/
    public void setCellValue(int x, int y, int value)
    {
        checkCoords(x, y);
        cells[x][y] = value;
    }

    /**
     * Returns the starting location for the map.  This is where the generated
     * path will begin from.
     **/
    public Location getStart()
    {
        return start;
    }

    /**
     * Sets the starting location for the map.  This is where the generated path
     * will begin from.
     **/
    public void setStart(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        start = loc;
    }

    /**
     * Returns the ending location for the map.  This is where the generated
     * path will terminate.
     **/
    public Location getFinish()
    {
        return finish;
    }

    /**
     * Sets the ending location for the map.  This is where the generated path
     * will terminate.
     **/
    public void setFinish(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc cannot be null");

        finish = loc;
    }
}
