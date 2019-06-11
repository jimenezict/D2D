package com.dataontheroad.minigis.map.service;

import com.dataontheroad.minigis.map.service.model.MapDTO;
import com.dataontheroad.minigis.map.repository.MapDataService;
import com.dataontheroad.minigis.map.message.Position;
import com.dataontheroad.minigis.map.message.RadialRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapService {

    public void setMapDataService(MapDataService mapDataService);

    public MapDTO getElementById(String i);

    public List<MapDTO> getElementsByPositionAndDistance(RadialRequest radialMessage);

    public Boolean saveNewlements(Position position);

}
