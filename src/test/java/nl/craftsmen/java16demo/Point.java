package nl.craftsmen.java16demo;

import lombok.Builder;

@Builder
public record Point(

        int x,
        int y

)
{
    static int stat;

    public Point {
        if (x <= -1) {
            throw new IllegalArgumentException();
        }
        System.out.println(stat);
    }
    public Point(int y) {
        this(0,0);
        this.stat = 0;
    }

}
