package com.codecool.marsexploration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapeGenerationAndPlacement {
    static char[][] generateMap(List<Integer> mountainAreas, List<Integer> pitAreas, int mapWidth) {
        Random random = new Random();

        List<char[][]> mountains = new ArrayList<>();
        for (int area : mountainAreas) {
            int rows = (int) Math.sqrt(area);
            int columns = (int) Math.ceil(area / (double) rows);

            char[][] mountain = new char[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    mountain[i][j] = '^';
                }
            }

            mountains.add(mountain);
        }


        List<char[][]> pits = new ArrayList<>();
        for (int area : pitAreas) {
            int rows = (int) Math.sqrt(area);
            int columns = (int) Math.ceil(area / (double) rows);

            char[][] pit = new char[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    pit[i][j] = '#';
                }
            }

            pits.add(pit);
        }

        // Place the mountains and pits on the map
        char[][] map = new char[mapWidth][mapWidth];
        for (char[][] mountain : mountains) {
            int x = random.nextInt(mapWidth - mountain[0].length + 1);
            int y = random.nextInt(mapWidth - mountain.length + 1);

            for (int i = 0; i < mountain.length; i++) {
                for (int j = 0; j < mountain[0].length; j++) {
                    map[y + i][x + j] = mountain[i][j];
                }
            }
        }
        for (char[][] pit : pits) {
            int x = random.nextInt(mapWidth - pit[0].length + 1);
            int y = random.nextInt(mapWidth - pit.length + 1);

            for (int i = 0; i < pit.length; i++) {
                for (int j = 0; j < pit[0].length; j++) {
                    map[y + i][x + j] = pit[i][j];
                }
            }
        }

        return map;
    }
}
