package com.dataontheroad.d2d.mapservice.repository.mongodb.repository;

import com.dataontheroad.d2d.mapservice.repository.mongodb.model.FountainMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FountainRepository extends MongoRepository<FountainMongo,String> {

}
