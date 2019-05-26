package com.dataontheroad.d2d.mapservice.repository.mongodb.services.statistics;

import com.dataontheroad.d2d.mapservice.repository.mongodb.services.statistics.model.StatisticsMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository extends MongoRepository<StatisticsMongo,String> {

}
