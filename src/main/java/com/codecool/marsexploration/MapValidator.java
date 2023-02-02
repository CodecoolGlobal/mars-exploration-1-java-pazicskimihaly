package com.codecool.marsexploration;

import java.util.List;

public class MapValidator {
    public static void validate(Configuration config, List<Pit> pits, List<Mountain> mountains) {
        int mapWidth = config.getMapWidth();
        int numMinerals = config.getNumMinerals();
        int numWater = config.getNumWater();

        for (Pit pit : pits) {
            int pitX = pit.getX();
            int pitY = pit.getY();
            int pitWidth = pit.getWidth();
            int pitHeight = pit.getHeight();

            if (pitX + pitWidth > mapWidth || pitY + pitHeight > mapWidth) {
                System.out.println("Error: Pit cannot be placed safely in the given area");
                System.exit(1);
            }
        }

        for (Mountain mountain : mountains) {
            int mountainX = mountain.getX();
            int mountainY = mountain.getY();
            int mountainWidth = mountain.getWidth();
            int mountainHeight = mountain.getHeight();

            if (mountainX + mountainWidth > mapWidth || mountainY + mountainHeight > mapWidth) {
                System.out.println("Error: Mountain cannot be placed safely in the given area");
                System.exit(1);
            }
        }

        if (numMinerals + numWater + pits.size() + mountains.size() > mapWidth * mapWidth) {
            System.out.println("Error: Not enough space in the given area to place all resources and terrain features");
            System.exit(1);
        }
    }
}
