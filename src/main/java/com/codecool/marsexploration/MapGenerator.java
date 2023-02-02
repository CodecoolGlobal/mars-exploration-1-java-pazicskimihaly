package com.codecool.marsexploration;

import java.util.List;
import java.util.Random;

public class MapGenerator {
    private Configuration config;
    private List<Pit> pits;
    private List<Mountain> mountains;
    private char[][] map;

    Random random = new Random();

    public MapGenerator(Configuration config, List<Pit> pits, List<Mountain> mountains) {
        this.config = config;
        this.pits = pits;
        this.mountains = mountains;
        this.map = new char[config.getMapWidth()][config.getMapWidth()];
    }

    public void generateMap() {
        for (int i = 0; i < config.getMapWidth(); i++) {
            for (int j = 0; j < config.getMapWidth(); j++) {
                map[i][j] = ' ';
            }
        }

        for (Pit pit : pits) {
            int pitX = pit.getX();
            int pitY = pit.getY();
            int pitWidth = pit.getWidth();
            int pitHeight = pit.getHeight();

            for (int i = pitX; i < pitX + pitWidth; i++) {
                for (int j = pitY; j < pitY + pitHeight; j++) {
                    map[i][j] = '#';
                }
            }
        }

        for (Mountain mountain : mountains) {
            int mountainX = mountain.getX();
            int mountainY = mountain.getY();
            int mountainWidth = mountain.getWidth();
            int mountainHeight = mountain.getHeight();

            for (int i = mountainX; i < mountainX + mountainWidth; i++) {
                for (int j = mountainY; j < mountainY + mountainHeight; j++) {
                    map[i][j] = '^';
                }
            }
        }

        for (int i = 0; i < config.getNumMinerals(); i++) {
            int mineralResourceX = random.nextInt(config.getMapWidth());
            int mineralResourceY = random.nextInt(config.getMapWidth());

            map[mineralResourceX][mineralResourceY] = '*';
        }

        for (int i = 0; i < config.getNumWater(); i++) {
            int waterResourceX = random.nextInt(config.getMapWidth());
            int waterResourceY = random.nextInt(config.getMapWidth());

            map[waterResourceX][waterResourceY] = '~';
        }
    }

    public char[][] getMap() {
        return map;
    }
}
