package com.dataontheroad.d2d.mapservice.repository.mongodb.model;

import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="fountain")
public class FountainMongo {

    @Id
    private ObjectId _id;
    private double[] position;

    public FountainMongo(ObjectId _id, double[] position) {
        this._id = _id;
        this.position = position;
    }

    public FountainMongo(double x, double y) {
        this.position = new double[] { x, y };
    }

    public FountainMongo(ObjectId _id, double x, double y) {
        this._id = _id;
        this.position = new double[] { x, y };
    }

    public double[] getPosition() {
        return position;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }
}
