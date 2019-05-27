package com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.Position;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizedMapPointRepositoryImpl implements CustomizedMapPointRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<MapPointMongo> filterByCircle(RadialMessage radialMessage) {
        Point point = new Point(radialMessage.getPosition().getX_cord(), radialMessage.getPosition().getY_cord());
        Distance distance = new Distance(radialMessage.getMeters() / 1000, Metrics.KILOMETERS);

        GeoResults<MapPointMongo> geoMapPointMongo =
                mongoTemplate
                        .geoNear(NearQuery.near(point).maxDistance(distance).num(radialMessage.getNumResults() + 1),
                        MapPointMongo.class, "MapPoints");

        List<MapPointMongo> closerMapPointLists = geoMapPointMongo
                .getContent()
                .stream()
                .map(x -> x.getContent())
                .collect(Collectors.toList());

        return closerMapPointLists;

    }

}
