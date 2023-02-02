package com.codecool.marsexploration;

import java.util.List;

public class Configuration {
    private String fileName;
    private int mapWidth;
    private List<Mountain> mountains;
    private List<Pit> pits;
    private int numMinerals;
    private int numWater;

    public Configuration(String fileName, int mapWidth, List<Mountain> mountains, List<Pit> pits, int numMinerals, int numWater) {
        this.fileName = fileName;
        this.mapWidth = mapWidth;
        this.mountains = mountains;
        this.pits = pits;
        this.numMinerals = numMinerals;
        this.numWater = numWater;
    }

    public String getFileName() {
        return fileName;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public List<Pit> getPits() {
        return pits;
    }

    public int getNumMinerals() {
        return numMinerals;
    }

    public int getNumWater() {
        return numWater;
    }
}
