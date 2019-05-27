package com.dataontheroad.d2d.mapservice.repository.mongodb;

import com.dataontheroad.d2d.mapservice.repository.MapDataService;
import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.MapPointRepository;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapDataServiceImpl implements MapDataService {

    @Autowired
    MapPointRepository mapPointRepository;

    @Override
    public MapBean getElementById(String id) {
        MapPointMongo fountainMongo = mapPointRepository.findById(id).orElse(new MapPointMongo(0,0));
        return new MapBean(fountainMongo.getPosition().getX(),fountainMongo.getPosition().getY());
    }

    @Override
    public List<MapBean> getElementsByPositionAndDistance(RadialMessage radialMessage) {
        Point point = new Point(radialMessage.position.getX_cord(), radialMessage.position.getY_cord());
        List<MapPointMongo> mapBeansList = filterOnTheCircle(radialMessage.meters,point);
        List<MapBean> mapBeanList = mapBeansList
                .stream()
                .limit(radialMessage.getResults())
                .map(x -> new MapBean(radialMessage.getPosition().getX_cord(),radialMessage.getPosition().getY_cord()))
                .collect(Collectors.toList());

        return mapBeanList;
    }

    private List<MapPointMongo> filterOnTheCircle(int meters, Point point) {
        if(meters > 0){
            return mapPointRepository.filterByCircle(meters,point);
        }
        return mapPointRepository.findAll();
    }

    @Override
    public ObjectId insertElement(MapBean mapBean){
        MapPointMongo fountainInserted = mapPointRepository.save(new MapPointMongo(mapBean.getX_cord(),mapBean.getY_cord()));
        return fountainInserted.get_id();
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
