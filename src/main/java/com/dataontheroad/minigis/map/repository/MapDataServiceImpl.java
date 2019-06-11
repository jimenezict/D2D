package com.dataontheroad.minigis.map.repository;

import com.dataontheroad.minigis.map.repository.model.MapPointMongo;
import com.dataontheroad.minigis.map.message.RadialRequest;
import com.dataontheroad.minigis.map.service.model.MapDTO;
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
    public MapDTO getElementById(String id) {
        MapPointMongo mapPointMongo = mapPointRepository.findById(id).orElse(new MapPointMongo(0,0));
        return new MapDTO(mapPointMongo.getPosition().getX(),mapPointMongo.getPosition().getY());
    }

    @Override
    public List<MapDTO> getElementsByPositionAndDistance(RadialRequest radialMessage) {

        return filterOnTheCircle(radialMessage)
                .stream()
                .limit(radialMessage.getNumResults())
                .map(x -> new MapDTO(x.getPosition().getX(),x.getPosition().getY()))
                .collect(Collectors.toList());

    }

    private List<MapPointMongo> filterOnTheCircle(RadialRequest radialMessage) {
        return (radialMessage.getMeters() > 0)? mapPointRepository.filterByCircle(radialMessage):mapPointRepository.findAll();
    }

    @Override
    public ObjectId insertElement(MapDTO mapBean){
        MapPointMongo mapPointMongo = mapPointRepository.save(new MapPointMongo(mapBean.getX_cord(),mapBean.getY_cord()));
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
