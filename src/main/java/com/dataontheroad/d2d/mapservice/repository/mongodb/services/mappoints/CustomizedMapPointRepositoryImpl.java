package com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.model.MapPointMongo;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;

import java.util.List;

public class CustomizedMapPointRepositoryImpl implements CustomizedMapPointRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<MapPointMongo> filterByCircle(int meters, Position position) {
        Point location = new Point(position.getX_cord(), position.getY_cord());
        Distance distance = new Distance(meters / 1000, Metrics.KILOMETERS);

        GeoResults<MapPointMongo> geoFountainMongo =
                mongoTemplate.geoNear(NearQuery.near(location).maxDistance(distance), MapPointMongo.class);

        geoFountainMongo.getContent();

        return null;
    }

}
