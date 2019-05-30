package com.dataontheroad.d2d.mapservice.repository.mongodb;

import com.dataontheroad.d2d.mapservice.repository.MapDataService;
import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.MapPointRepository;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
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
    public MapBean getElementById(String id) {
        MapPointMongo mapPointMongo = mapPointRepository.findById(id).orElse(new MapPointMongo(0,0));
        return new MapBean(mapPointMongo.getPosition().getX(),mapPointMongo.getPosition().getY());
    }

    @Override
    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage) {

        return filterOnTheCircle(radialMessage)
                .stream()
                .limit(radialMessage.getNumResults())
                .map(x -> new MapBean(x.getPosition().getX(),x.getPosition().getY()))
                .collect(Collectors.toList());

    }

    private List<MapPointMongo> filterOnTheCircle(RadialMessage radialMessage) {
        return (radialMessage.getMeters() > 0)? mapPointRepository.filterByCircle(radialMessage):mapPointRepository.findAll();
    }

    @Override
    public ObjectId insertElement(MapBean mapBean){
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
