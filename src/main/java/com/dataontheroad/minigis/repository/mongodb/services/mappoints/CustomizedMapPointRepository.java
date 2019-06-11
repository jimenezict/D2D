package com.dataontheroad.minigis.repository.mongodb.services.mappoints;

import com.dataontheroad.minigis.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;

import java.util.List;

public interface CustomizedMapPointRepository {

    public List<MapPointMongo> filterByCircle(RadialMessage radialMessage);
}
