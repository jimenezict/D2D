package com.dataontheroad.minigis.services.map;

import com.dataontheroad.minigis.repository.MapDataService;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.Position;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapService {

    public void setMapDataService(MapDataService mapDataService);

    public MapBean getElementById(String i);

    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage);

    public Boolean saveNewlements(Position position);

}
