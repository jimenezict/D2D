package com.dataontheroad.d2d.mapservice.repository.mongodb.repository;

import com.dataontheroad.d2d.mapservice.repository.mongodb.model.StatisticsMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository extends MongoRepository<StatisticsMongo,String> {

}
