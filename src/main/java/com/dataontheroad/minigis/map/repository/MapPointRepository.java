package com.dataontheroad.minigis.map.repository;

import com.dataontheroad.minigis.map.repository.model.MapPointMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapPointRepository extends MongoRepository<MapPointMongo,String>, CustomizedMapPointRepository {

}
