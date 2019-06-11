package com.dataontheroad.minigis.statistics.service;

import com.dataontheroad.minigis.statistics.repository.StatisticsDataService;
import com.dataontheroad.minigis.statistics.service.model.StatisticsDTO;
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
    public StatisticsDTO getStatistics() {
        StatisticsDTO statistic = statisticsDataService.getStatistics();
        if(statistic == null)
            return new StatisticsDTO(0,0,0);
        return statistic;
    }
}
