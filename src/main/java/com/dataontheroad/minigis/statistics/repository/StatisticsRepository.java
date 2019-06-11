package com.dataontheroad.minigis.statistics.repository;

import com.dataontheroad.minigis.statistics.repository.model.StatisticsMongoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository extends MongoRepository<StatisticsMongoDTO,String> {

}
