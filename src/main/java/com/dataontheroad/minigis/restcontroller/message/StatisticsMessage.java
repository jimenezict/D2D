package com.dataontheroad.minigis.restcontroller.message;

import com.dataontheroad.minigis.common.BaseMessage;
import com.dataontheroad.minigis.services.statistics.StatisticsBean;

public class StatisticsMessage extends BaseMessage {

    private StatisticsBean statistics;

    public StatisticsMessage(StatisticsBean statistics){
        super("Statistic");
        this.statistics = statistics;
    }

    public StatisticsBean getStatisticsBean(){
        return statistics;
    }

}
