package com.dataontheroad.d2d.mapservice.repository.mongodb.services.fountain;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.fountain.model.FountainMongo;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.Position;

import java.util.List;

public interface CustomizedFountainRepository {

    public List<FountainMongo> filterByCircle(int meters, Position position);
}
