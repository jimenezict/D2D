package com.dataontheroad.d2d.mapservice.services.statistics;

import com.dataontheroad.d2d.mapservice.queryservice.StatisticsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsImpl implements Statistics {

    @Autowired
    private StatisticsDataService statisticsDataService;

    public void setStatisticsDataService(StatisticsDataService statisticsDataService) {
        this.statisticsDataService = statisticsDataService;
    }

    @Override
    public StatisticsBean getStatistics() {
        StatisticsBean statistic = statisticsDataService.getStatistics();
        if(statistic == null)
            return new StatisticsBean(0,0,0);
        return statistic;
    }
}
