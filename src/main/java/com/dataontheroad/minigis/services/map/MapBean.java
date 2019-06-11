package com.dataontheroad.minigis.services.map;

public class MapBean {

    private double x_cord;
    private double y_cord;

    public MapBean(double x_cord, double y_cord) {
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
