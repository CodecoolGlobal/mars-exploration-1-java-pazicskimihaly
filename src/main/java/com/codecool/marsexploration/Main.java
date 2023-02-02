package com.codecool.marsexploration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration("map.txt", 10, List.of(new Mountain(2,2,2,2), new Mountain(4,4,2,2)), List.of(new Pit(6,6,2,2), new Pit(8,8,2,2)), 5, 5);
        MapGenerator mapGenerator = new MapGenerator(config, List.of(new Pit(2,2,2,2), new Pit(4,4,2,2)), List.of(new Mountain(6,6,2,2), new Mountain(8,8,2,2)));
        char[][] map = mapGenerator.generateMap();
        MapValidator.validate(config, List.of(new Pit(6,6,2,2), new Pit(8,8,2,2)), List.of(new Mountain(2,2,2,2), new Mountain(4,4,2,2)));

        try (FileWriter writer = new FileWriter(config.getFileName())) {
            for (char [] row : map) {
                for (char cell : row) {
                    writer.write(cell + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}