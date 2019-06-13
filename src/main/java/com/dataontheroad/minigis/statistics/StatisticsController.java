package com.dataontheroad.minigis.statistics;

import com.dataontheroad.minigis.statistics.message.StatisticsResponse;
import com.dataontheroad.minigis.statistics.service.Statistics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    @Autowired
    private Statistics statistics;

    Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    @GetMapping("/statistics")
    @ResponseBody
    public StatisticsResponse getStatistics(){
        logger.info("Call to Get Statistics Controller REST");
        return new StatisticsResponse(statistics.getStatistics());
    }
}
