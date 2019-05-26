package com.dataontheroad.d2d.mapservice.repository;

import com.dataontheroad.d2d.mapservice.services.statistics.StatisticsBean;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsDataService extends BaseDataService{

    StatisticsBean getStatistics();

    public void insertElement(StatisticsBean statitsticsBean);

}
