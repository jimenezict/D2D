package com.dataontheroad.minigis.services.map;

import com.dataontheroad.minigis.repository.MapDataService;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.Position;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;
import org.bson.types.ObjectId;
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
    public MapBean getElementById(String i) {
        return mapDataService.getElementById(i);
    }

    @Override
    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage) {
        return mapDataService.getElementsByPositionAndDistance(radialMessage);
    }

    @Override
    public Boolean saveNewlements(Position position) {
        ObjectId result = mapDataService.insertElement(new MapBean(position.getX_cord(),position.getY_cord()));
        return (result==null)?false:true;
    }
}
