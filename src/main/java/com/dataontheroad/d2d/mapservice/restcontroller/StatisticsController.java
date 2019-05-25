package com.dataontheroad.d2d.mapservice.restcontroller;

import com.dataontheroad.d2d.mapservice.restcontroller.message.StatisticsMessage;
import com.dataontheroad.d2d.mapservice.services.statistics.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    @Autowired
    private Statistics statistics;

    @GetMapping("/statistics")
    @ResponseBody
    public StatisticsMessage getStatistics(){
        return new StatisticsMessage(statistics.getStatistics());
    }
}
