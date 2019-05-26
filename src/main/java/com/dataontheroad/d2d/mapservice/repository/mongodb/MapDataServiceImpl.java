package com.dataontheroad.d2d.mapservice.repository.mongodb;

import com.dataontheroad.d2d.mapservice.repository.MapDataService;
import com.dataontheroad.d2d.mapservice.repository.mongodb.model.FountainMongo;
import com.dataontheroad.d2d.mapservice.repository.mongodb.repository.FountainRepository;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class MapDataServiceImpl implements MapDataService {

    @Autowired
    FountainRepository fountainRepository;

    @Override
    public MapBean getElementById(String id) {
        FountainMongo fountainMongo = fountainRepository.findById(id).orElse(new FountainMongo(0,0));
        return new MapBean(fountainMongo.getPosition()[0],fountainMongo.getPosition()[1]);
    }

    @Override
    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage) {
        List<FountainMongo> mapBeansList = fountainRepository.findAll();
        List<MapBean> mapBeanList = mapBeansList
                .stream()
                .limit(radialMessage.getResults())
                .map(x -> new MapBean(radialMessage.getPosition().getX_cord(),radialMessage.getPosition().getY_cord()))
                .collect(Collectors.toList());

        return mapBeanList;
    }

    @Override
    public ObjectId insertElement(MapBean mapBean){
        FountainMongo fountainInserted = fountainRepository.save(new FountainMongo(mapBean.getX_cord(),mapBean.getY_cord()));
        return fountainInserted.get_id();
    }

    @Override
    public void emptyElements() {
        fountainRepository.deleteAll();
    }

    @Override
    public long countStatistics(){
        return fountainRepository.count();
    }

}
