package com.dataontheroad.minigis.statistics.repository;

import com.dataontheroad.minigis.common.BaseDataService;
import com.dataontheroad.minigis.statistics.service.model.StatisticsDTO;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsDataService extends BaseDataService {

    StatisticsDTO getStatistics();

    public void insertElement(StatisticsDTO statitsticsBean);

}
