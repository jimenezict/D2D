package com.dataontheroad.minigis.statistics.message;

import com.dataontheroad.minigis.common.BaseMessage;
import com.dataontheroad.minigis.statistics.service.model.StatisticsDTO;

public class StatisticsResponse extends BaseMessage {

    private StatisticsDTO statistics;

    public StatisticsResponse(StatisticsDTO statistics){
        super("Statistic");
        this.statistics = statistics;
    }

    public StatisticsDTO getStatisticsBean(){
        return statistics;
    }

}
