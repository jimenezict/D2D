package com.dataontheroad.minigis.map.repository;

import com.dataontheroad.minigis.common.BaseDataService;
import com.dataontheroad.minigis.map.message.RadialRequest;
import com.dataontheroad.minigis.map.service.model.MapDTO;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapDataService extends BaseDataService {

    MapDTO getElementById(String id);

    List<MapDTO> getElementsByPositionAndDistance(RadialRequest radialMessage);

    public ObjectId insertElement(MapDTO mapBean);

}
