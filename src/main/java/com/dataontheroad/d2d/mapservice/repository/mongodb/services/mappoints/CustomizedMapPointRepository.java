package com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.Position;

import java.util.List;

public interface CustomizedMapPointRepository {

    public List<MapPointMongo> filterByCircle(int meters, Position position);
}
