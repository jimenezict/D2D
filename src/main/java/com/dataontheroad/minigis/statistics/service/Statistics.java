package com.dataontheroad.minigis.statistics.service;

import com.dataontheroad.minigis.statistics.repository.StatisticsDataService;
import org.springframework.stereotype.Service;

@Service
public interface Statistics {

    public StatisticsBean getStatistics();

    public void setStatisticsDataService(StatisticsDataService statisticsDataService);

}
