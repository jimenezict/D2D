package com.dataontheroad.d2d.mapservice.services.map;

import com.dataontheroad.d2d.mapservice.queryservice.MapDataService;
import com.dataontheroad.d2d.mapservice.restcomponents.message.PostRequest.RadialMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapService {

    public void setMapDataService(MapDataService mapDataService);

    public MapBean getElementById(int i);

    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage);

}
