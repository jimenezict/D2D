package com.dataontheroad.minigis.repository;

import com.dataontheroad.minigis.common.BaseDataService;
import com.dataontheroad.minigis.services.statistics.StatisticsBean;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsDataService extends BaseDataService {

    StatisticsBean getStatistics();

    public void insertElement(StatisticsBean statitsticsBean);

}
