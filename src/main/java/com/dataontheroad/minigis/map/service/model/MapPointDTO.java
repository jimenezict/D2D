package com.dataontheroad.minigis.map.service.model;

public class MapPointDTO {

    private double x_cord;
    private double y_cord;

    public MapPointDTO(double x_cord, double y_cord) {
        this.x_cord = x_cord;
        this.y_cord = y_cord;
    }

    public double getX_cord() {
        return x_cord;
    }

    public double getY_cord() {
        return y_cord;
    }
}
