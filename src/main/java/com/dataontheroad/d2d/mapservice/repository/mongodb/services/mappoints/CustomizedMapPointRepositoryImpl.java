package com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;

import java.util.List;
import java.util.stream.Collectors;

public class CustomizedMapPointRepositoryImpl implements CustomizedMapPointRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<MapPointMongo> filterByCircle(RadialMessage radialMessage) {
        return convertMapPointsToList(getMapPointsByDistance(radialMessage));
    }

    @NotNull
    private List<MapPointMongo> convertMapPointsToList(GeoResults<MapPointMongo> geoMapPointMongo) {
        return geoMapPointMongo
                .getContent()
                .stream()
                .map(x -> x.getContent())
                .collect(Collectors.toList());
    }

    private GeoResults<MapPointMongo> getMapPointsByDistance(RadialMessage radialMessage) {
        Point point = getPoint(radialMessage);
        Distance distance = getDistance(radialMessage);

        return mongoTemplate
                .geoNear(NearQuery.near(point).maxDistance(distance).num(radialMessage.getNumResults() + 1),
                MapPointMongo.class, "MapPoints");
    }

    @NotNull
    private Distance getDistance(RadialMessage radialMessage) {
        return new Distance(radialMessage.getMeters() / 1000, Metrics.KILOMETERS);
    }

    @NotNull
    private Point getPoint(RadialMessage radialMessage) {
        return new Point(radialMessage.getPosition().getX_cord(), radialMessage.getPosition().getY_cord());
    }

}
