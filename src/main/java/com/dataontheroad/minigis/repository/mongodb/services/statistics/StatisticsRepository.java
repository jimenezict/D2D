package com.dataontheroad.minigis.repository.mongodb.services.statistics;

import com.dataontheroad.minigis.repository.mongodb.services.statistics.model.StatisticsMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository extends MongoRepository<StatisticsMongo,String> {

}
