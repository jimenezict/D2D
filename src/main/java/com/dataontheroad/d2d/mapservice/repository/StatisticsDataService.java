package com.dataontheroad.d2d.mapservice.repository;

import com.dataontheroad.d2d.mapservice.services.statistics.StatisticsBean;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsDataService {

    StatisticsBean getStatistics();

    public void newStatistics(StatisticsBean statitsticsBean);

    public long countStatistics();

    public void emptyStatistics();

}
