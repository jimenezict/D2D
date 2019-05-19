package com.dataontheroad.d2d.mapservice.restcomponents.message;

import com.dataontheroad.d2d.mapservice.services.statistics.StatisticsBean;

public class StatisticsMessage extends Message {

    private StatisticsBean statistics;

    public StatisticsMessage(StatisticsBean statistics){
        super("Statistic");
        this.statistics = statistics;
    }

    public StatisticsBean getStatisticsBean(){
        return statistics;
    }

}
