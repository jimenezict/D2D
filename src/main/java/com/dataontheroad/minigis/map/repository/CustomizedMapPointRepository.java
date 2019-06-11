package com.dataontheroad.minigis.map.repository;

import com.dataontheroad.minigis.map.repository.model.MapPointMongoDTO;
import com.dataontheroad.minigis.map.message.RadialRequest;

import java.util.List;

public interface CustomizedMapPointRepository {

    public List<MapPointMongoDTO> filterByCircle(RadialRequest radialMessage);
}
