package com.dataontheroad.d2d.mapservice.restcomponents;

import com.dataontheroad.d2d.mapservice.restcomponents.message.StatisticsMessage;
import com.dataontheroad.d2d.mapservice.services.statistics.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsRest {

    @Autowired
    private Statistics statistics;

    @GetMapping("/statistics")
    @ResponseBody
    public StatisticsMessage getStatistics(){
        return new StatisticsMessage(statistics.getStatistics());
    }
}
