package com.dataontheroad.d2d.mapservice.repository.mongodb.services.statistics.model;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="Statistics")
public class StatisticsMongo {

    @Id
    private ObjectId _id;
    private int countries;
    private int fountains;
    private int users;
    private LocalDateTime timestamp;

    public StatisticsMongo(){

    }

    public StatisticsMongo(ObjectId _id, int countries, int fountains, int users, LocalDateTime timestamp) {
        this._id = _id;
        this.countries = countries;
        this.fountains = fountains;
        this.users = users;
        this.timestamp = timestamp;
    }

    public StatisticsMongo(ObjectId _id, int countries, int fountains, int users ) {
        this._id = _id;
        this.countries = countries;
        this.fountains = fountains;
        this.users = users;
        this.timestamp = LocalDateTime.now();
    }

    public StatisticsMongo(int countries, int fountains, int users ) {
        this._id = ObjectId.get();
        this.countries = countries;
        this.fountains = fountains;
        this.users = users;
        this.timestamp = LocalDateTime.now();
    }

    public int getCountries() {
        return countries;
    }

    public int getFountains() {
        return fountains;
    }

    public int getUsers() {
        return users;
    }

    public LocalDateTime getTimestamp(){ return timestamp;}

    public void setCountries(int countries) {
        this.countries = countries;
    }

    public void setFountains(int fountains) {
        this.fountains = fountains;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
