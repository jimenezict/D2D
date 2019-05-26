package com.dataontheroad.d2d.mapservice.repository.mongodb.services.fountain;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.fountain.model.FountainMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FountainRepository extends MongoRepository<FountainMongo,String>, CustomizedFountainRepository {

}
