package com.dataontheroad.d2d.mapservice.restcomponents.message.PostRequest;

import com.dataontheroad.d2d.mapservice.restcomponents.message.Message;

public class RadialMessage{

    public Position position;
    public int meters;
    public int results;

    public RadialMessage(Position position, int meters, int results) {
        this.position = position;
        this.meters = meters;
        this.results = results;
    }

    public Position getPosition() {
        return position;
    }

    public int getMeters() {
        return meters;
    }

    public int getResults() {
        return results;
    }

}
