package com.dataontheroad.minigis.map.repository.service;

import com.dataontheroad.minigis.common.BaseDataService;
import com.dataontheroad.minigis.map.message.RadialRequest;
import com.dataontheroad.minigis.map.service.model.MapPointDTO;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapDataService extends BaseDataService {

    MapPointDTO getElementById(String id);

    List<MapPointDTO> getElementsByPositionAndDistance(RadialRequest radialMessage);

    public ObjectId insertElement(MapPointDTO mapBean);

}
