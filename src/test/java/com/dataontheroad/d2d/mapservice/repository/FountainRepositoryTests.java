package com.dataontheroad.d2d.mapservice.repository;

import com.dataontheroad.d2d.mapservice.services.statistics.StatisticsBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FountainRepositoryTests {

	@Autowired
	StatisticsDataService statisticsDataService;

	@Test
	public void MongoStatisticsInsertRepositoryTests() {
		statisticsDataService.emptyStatistics();
		long inisize = statisticsDataService.countStatistics();
		statisticsDataService.newStatistics(new StatisticsBean(1,5,1));
		long endsize = statisticsDataService.countStatistics();
		statisticsDataService.emptyStatistics();
		assertEquals(inisize + 1, endsize);
	}

	@Test
	public void MongoStatisticsGetRepositoryNullTests() {
		statisticsDataService.emptyStatistics();
		assertNull(statisticsDataService.getStatistics());
	}

	@Test
	public void MongoStatisticsGetRepositoryTests() {
		statisticsDataService.emptyStatistics();
		statisticsDataService.newStatistics(new StatisticsBean(1,50,1));
		statisticsDataService.newStatistics(new StatisticsBean(2,500,10));
		statisticsDataService.newStatistics(new StatisticsBean(3,5000,100));
		statisticsDataService.newStatistics(new StatisticsBean(4,50000,1000));
		statisticsDataService.newStatistics(new StatisticsBean(5,500000,10000));
		statisticsDataService.newStatistics(new StatisticsBean(6,5000000,100000));
		statisticsDataService.newStatistics(new StatisticsBean(7,50000000,1000000));
		assertEquals(7,statisticsDataService.getStatistics().getCountries());

	}

}
