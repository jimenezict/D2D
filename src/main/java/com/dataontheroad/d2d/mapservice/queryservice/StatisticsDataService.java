package com.dataontheroad.d2d.mapservice.queryservice;

import com.dataontheroad.d2d.mapservice.services.statistics.StatisticsBean;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsDataService {

    StatisticsBean getStatistics();

}
