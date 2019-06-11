package com.dataontheroad.minigis.statistics.repository;

import com.dataontheroad.minigis.statistics.repository.model.StatisticsMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository extends MongoRepository<StatisticsMongo,String> {

}
