package com.dataontheroad.minigis.repository.mongodb.services.mappoints;

import com.dataontheroad.minigis.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;

import javax.validation.constraints.NotNull;
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
        return mongoTemplate
                .geoNear(NearQuery.near(getPoint(radialMessage))
                                .maxDistance(getDistance(radialMessage))
                                .num(radialMessage.getNumResults()),
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
