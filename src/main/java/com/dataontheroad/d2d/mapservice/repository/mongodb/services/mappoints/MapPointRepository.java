package com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.mappoints.model.MapPointMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapPointRepository extends MongoRepository<MapPointMongo,String>, CustomizedMapPointRepository {

}
