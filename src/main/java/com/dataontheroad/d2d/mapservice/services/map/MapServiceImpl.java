package com.dataontheroad.d2d.mapservice.services.map;

import com.dataontheroad.d2d.mapservice.repository.MapDataService;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService{

    @Autowired
    private MapDataService mapDataService;

    @Override
    public void setMapDataService(MapDataService mapDataService) {
        this.mapDataService = mapDataService;
    }

    @Override
    public MapBean getElementById(int i) {
        return mapDataService.getElementById(i);
    }

    @Override
    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage) {
        return mapDataService.getElementsByPositionAndDistance(radialMessage);
    }
}
