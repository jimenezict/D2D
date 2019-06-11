package com.dataontheroad.minigis.repository;

import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.minigis.services.map.MapBean;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MapDataService extends BaseDataService{

    MapBean getElementById(String id);

    List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage);

    public ObjectId insertElement(MapBean mapBean);

}
