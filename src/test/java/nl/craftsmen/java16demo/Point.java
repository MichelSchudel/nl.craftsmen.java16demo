package nl.craftsmen.java16demo;

import lombok.Builder;

@Builder
public record Point(

        int x,
        int y

) {}
