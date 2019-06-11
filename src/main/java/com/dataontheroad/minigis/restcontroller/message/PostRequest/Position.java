package com.dataontheroad.minigis.restcontroller.message.PostRequest;

public class Position {
    private Double x_cord;
    private Double y_cord;

    public Position(Double x_cord, Double y_cord) {
        this.x_cord = x_cord;
        this.y_cord = y_cord;
    }

    public Double getX_cord() {
        return x_cord;
    }


    public Double getY_cord() {
        return y_cord;
    }
}
