package com.dataontheroad.minigis.map.repository;

import com.dataontheroad.minigis.map.repository.model.MapPointMongoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MapPointRepository extends MongoRepository<MapPointMongoDTO,String>, CustomizedMapPointRepository {

}
