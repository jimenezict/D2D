package com.dataontheroad.minigis.statistics.repository;

import com.dataontheroad.minigis.statistics.repository.model.StatisticsMongo;
import com.dataontheroad.minigis.statistics.service.StatisticsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StatisticsDataServiceImpl implements StatisticsDataService {
    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public void insertElement(StatisticsBean statitsticsBean){
        statisticsRepository
                .save(
                        new StatisticsMongo(
                                statitsticsBean.getCountries(),
                                statitsticsBean.getItems(),
                                statitsticsBean.getUsers()));
    }

    @Override
    public StatisticsBean getStatistics(){
        List<StatisticsMongo> statistics = statisticsRepository.findAll();
        if(statistics!= null && statistics.size() == 0){
            return null;
        }
        List<StatisticsMongo> orderedstatistics =
                statistics.stream().sorted(Comparator.comparing(StatisticsMongo::getTimestamp).reversed()).collect(Collectors.toList());
        return new StatisticsBean(orderedstatistics.get(0).getCountries(),orderedstatistics.get(0).getMapBeans(),orderedstatistics.get(0).getUsers());
    }

    @Override
    public long countStatistics(){
        return statisticsRepository.count();
    }

    @Override
    public void emptyElements(){
        statisticsRepository.deleteAll();
    }

}
