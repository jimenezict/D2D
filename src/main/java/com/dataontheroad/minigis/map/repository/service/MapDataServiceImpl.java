package com.dataontheroad.minigis.map.repository.service;

import com.dataontheroad.minigis.map.repository.MapPointRepository;
import com.dataontheroad.minigis.map.repository.model.MapPointMongoDTO;
import com.dataontheroad.minigis.map.message.RadialRequest;
import com.dataontheroad.minigis.map.service.model.MapPointDTO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapDataServiceImpl implements MapDataService {

    @Autowired
    MapPointRepository mapPointRepository;

    @Override
    public MapPointDTO getElementById(String id) {
        MapPointMongoDTO mapPointMongo = mapPointRepository.findById(id).orElse(new MapPointMongoDTO(0,0));
        return new MapPointDTO(mapPointMongo.getPosition().getX(),mapPointMongo.getPosition().getY());
    }

    @Override
    public List<MapPointDTO> getElementsByPositionAndDistance(RadialRequest radialMessage) {

        return filterOnTheCircle(radialMessage)
                .stream()
                .limit(radialMessage.getNumResults())
                .map(x -> new MapPointDTO(x.getPosition().getX(),x.getPosition().getY()))
                .collect(Collectors.toList());

    }

    private List<MapPointMongoDTO> filterOnTheCircle(RadialRequest radialMessage) {
        return (radialMessage.getMeters() > 0)? mapPointRepository.filterByCircle(radialMessage):mapPointRepository.findAll();
    }

    @Override
    public ObjectId insertElement(MapPointDTO mapBean){
        MapPointMongoDTO mapPointMongo = mapPointRepository.save(new MapPointMongoDTO(mapBean.getX_cord(),mapBean.getY_cord()));
        return mapPointMongo.get_id();
    }

    @Override
    public void emptyElements() {
        mapPointRepository.deleteAll();
    }

    @Override
    public long countStatistics(){
        return mapPointRepository.count();
    }

}
