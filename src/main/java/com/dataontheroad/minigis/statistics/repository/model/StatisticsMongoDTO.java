package com.dataontheroad.minigis.statistics.repository.model;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="Statistics")
public class StatisticsMongoDTO {

    @Id
    private ObjectId _id;
    private int countries;
    private int mapBeans;
    private int users;
    private LocalDateTime timestamp;

    public StatisticsMongoDTO(){

    }

    public StatisticsMongoDTO(ObjectId _id, int countries, int mapBeans, int users, LocalDateTime timestamp) {
        this._id = _id;
        this.countries = countries;
        this.mapBeans = mapBeans;
        this.users = users;
        this.timestamp = timestamp;
    }

    public StatisticsMongoDTO(ObjectId _id, int countries, int mapBeans, int users ) {
        this._id = _id;
        this.countries = countries;
        this.mapBeans = mapBeans;
        this.users = users;
        this.timestamp = LocalDateTime.now();
    }

    public StatisticsMongoDTO(int countries, int mapBeans, int users ) {
        this._id = ObjectId.get();
        this.countries = countries;
        this.mapBeans = mapBeans;
        this.users = users;
        this.timestamp = LocalDateTime.now();
    }

    public int getCountries() {
        return countries;
    }

    public int getMapBeans() {
        return mapBeans;
    }

    public int getUsers() {
        return users;
    }

    public LocalDateTime getTimestamp(){ return timestamp;}

    public void setCountries(int countries) {
        this.countries = countries;
    }

    public void setMapBeans(int mapBeans) {
        this.mapBeans = mapBeans;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
