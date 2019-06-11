package com.dataontheroad.minigis.restcontroller.message.PostRequest;

public class RadialMessage{

    private Position position;
    private int meters;
    private int numResults;

    public RadialMessage(Position position, int meters, int results) {
        this.position = position;
        this.meters = meters;
        this.numResults = results;
    }

    public Position getPosition() {
        return position;
    }

    public int getMeters() {
        return meters;
    }

    public int getNumResults() {
        return numResults;
    }

}
