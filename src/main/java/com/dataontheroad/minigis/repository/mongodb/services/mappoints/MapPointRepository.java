package com.dataontheroad.minigis.repository.mongodb.services.mappoints;

import com.dataontheroad.minigis.repository.mongodb.services.mappoints.model.MapPointMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapPointRepository extends MongoRepository<MapPointMongo,String>, CustomizedMapPointRepository {

}
