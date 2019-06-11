package com.dataontheroad.minigis.map.repository.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="MapPoints")
public class MapPointMongo {

    @Id
    private ObjectId _id;
    private Point position;

    public MapPointMongo(){

    }

    public MapPointMongo(ObjectId _id, Point position) {
        this._id = _id;
        this.position = position;
    }

    public MapPointMongo(double x, double y) {
        this.position = new Point(x,y);
    }

    public MapPointMongo(ObjectId _id, double x, double y) {
        this._id = _id;
        this.position = new Point(x,y);
    }

    public Point getPosition() {
        return position;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId get_id(){
        return _id;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
