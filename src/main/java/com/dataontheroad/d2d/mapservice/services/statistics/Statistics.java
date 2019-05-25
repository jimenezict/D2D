package com.dataontheroad.d2d.mapservice.services.statistics;

import com.dataontheroad.d2d.mapservice.repository.StatisticsDataService;
import org.springframework.stereotype.Service;

@Service
public interface Statistics {

    public StatisticsBean getStatistics();

    public void setStatisticsDataService(StatisticsDataService statisticsDataService);

}
