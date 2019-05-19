package com.dataontheroad.d2d.mapservice.services.map;

import com.dataontheroad.d2d.mapservice.queryservice.MapDataService;
import org.springframework.stereotype.Service;

@Service
public interface MapService {

    public MapBean getElementById(int i);

    public void setMapDataService(MapDataService mapDataService);

}
