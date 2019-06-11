package com.dataontheroad.minigis.statistics.repository;

import com.dataontheroad.minigis.common.BaseDataService;
import com.dataontheroad.minigis.statistics.service.StatisticsBean;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsDataService extends BaseDataService {

    StatisticsBean getStatistics();

    public void insertElement(StatisticsBean statitsticsBean);

}
