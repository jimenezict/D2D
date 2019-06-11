package com.dataontheroad.minigis.statistics.service;

import com.dataontheroad.minigis.statistics.repository.StatisticsDataService;
import com.dataontheroad.minigis.statistics.service.model.StatisticsDTO;
import org.springframework.stereotype.Service;

@Service
public interface Statistics {

    public StatisticsDTO getStatistics();

    public void setStatisticsDataService(StatisticsDataService statisticsDataService);

}
