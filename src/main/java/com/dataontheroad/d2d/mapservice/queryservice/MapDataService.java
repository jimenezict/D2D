package com.dataontheroad.d2d.mapservice.queryservice;

import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import org.springframework.stereotype.Service;

@Service
public interface MapDataService {

    MapBean getElementById(int id);

}
