package com.dataontheroad.minigis.map.repository;

import com.dataontheroad.minigis.map.repository.model.MapPointMongo;
import com.dataontheroad.minigis.map.message.RadialRequest;

import java.util.List;

public interface CustomizedMapPointRepository {

    public List<MapPointMongo> filterByCircle(RadialRequest radialMessage);
}
