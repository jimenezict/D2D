package com.dataontheroad.d2d.mapservice.repository;

import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapDataService extends BaseDataService{

    MapBean getElementById(String id);

    List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage);

    public ObjectId insertElement(MapBean mapBean);

}
