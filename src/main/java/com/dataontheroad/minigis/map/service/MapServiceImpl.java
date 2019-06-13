package com.dataontheroad.minigis.map.service;

import com.dataontheroad.minigis.map.service.model.MapPointDTO;
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
    public MapPointDTO getElementById(String i) {
        return mapDataService.getElementById(i);
    }

    @Override
    public List<MapPointDTO> getElementsByPositionAndDistance(RadialRequest radialMessage) {
        return mapDataService.getElementsByPositionAndDistance(radialMessage);
    }

    @Override
    public Boolean saveNewPosition(Position position) {
        ObjectId result = mapDataService.insertElement(new MapPointDTO(position.getX_cord(),position.getY_cord()));
        return (result==null)?false:true;
    }
}
