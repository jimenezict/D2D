package com.dataontheroad.minigis.map.service;

import com.dataontheroad.minigis.map.service.model.MapDTO;
import com.dataontheroad.minigis.map.repository.service.MapDataService;
import com.dataontheroad.minigis.map.message.Position;
import com.dataontheroad.minigis.map.message.RadialRequest;
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
    public MapDTO getElementById(String i) {
        return mapDataService.getElementById(i);
    }

    @Override
    public List<MapDTO> getElementsByPositionAndDistance(RadialRequest radialMessage) {
        return mapDataService.getElementsByPositionAndDistance(radialMessage);
    }

    @Override
    public Boolean saveNewlements(Position position) {
        ObjectId result = mapDataService.insertElement(new MapDTO(position.getX_cord(),position.getY_cord()));
        return (result==null)?false:true;
    }
}
