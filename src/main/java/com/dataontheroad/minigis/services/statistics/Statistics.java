package com.dataontheroad.minigis.services.statistics;

import com.dataontheroad.minigis.repository.StatisticsDataService;
import org.springframework.stereotype.Service;

@Service
public interface Statistics {

    public StatisticsBean getStatistics();

    public void setStatisticsDataService(StatisticsDataService statisticsDataService);

}
