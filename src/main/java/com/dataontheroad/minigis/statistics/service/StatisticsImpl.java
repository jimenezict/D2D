package com.dataontheroad.minigis.statistics.service;

import com.dataontheroad.minigis.statistics.repository.StatisticsDataService;
import com.dataontheroad.minigis.statistics.service.model.StatisticsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatisticsImpl implements Statistics {

    @Autowired
    private StatisticsDataService statisticsDataService;

    Logger logger = LoggerFactory.getLogger(StatisticsImpl.class);

    public void setStatisticsDataService(StatisticsDataService statisticsDataService) {
        this.statisticsDataService = statisticsDataService;
    }

    @Override
    public StatisticsDTO getStatistics() {
        StatisticsDTO statistic = statisticsDataService.getStatistics();
        if(statistic == null) {
            logger.info("Get Statistics Service: Not Statistics on Database");
            return new StatisticsDTO(0, 0, 0);
        }
        logger.debug("Get Statistics Service: countries {}, items {}, users {} ",
                statistic.getCountries(),statistic.getItems(),statistic.getUsers());
        return statistic;
    }
}
