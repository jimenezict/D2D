package com.dataontheroad.d2d.mapservice.restcomponents.message.PostRequest;

public class Position {
    private double x_cord;
    private double y_cord;

    public Position(double x_cord, double y_cord) {
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
