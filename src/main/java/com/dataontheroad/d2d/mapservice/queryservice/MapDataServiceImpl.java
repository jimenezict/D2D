package com.dataontheroad.d2d.mapservice.queryservice;

import com.dataontheroad.d2d.mapservice.restcomponents.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapDataServiceImpl implements MapDataService{

    @Override
    public MapBean getElementById(int id) {
        return null;
    }

    @Override
    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage) {
        List<MapBean> mapBeansList = new ArrayList<>();
        return mapBeansList;
    }
}
