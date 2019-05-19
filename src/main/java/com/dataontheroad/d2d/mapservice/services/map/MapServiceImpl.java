package com.dataontheroad.d2d.mapservice.services.map;

import com.dataontheroad.d2d.mapservice.queryservice.MapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
