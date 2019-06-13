package com.dataontheroad.minigis.statistics;

import com.dataontheroad.minigis.statistics.service.model.StatisticsDTO;
import com.dataontheroad.minigis.statistics.repository.StatisticsDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsRepositoryTests {

	@Autowired
    StatisticsDataService statisticsDataService;

	@Test
	public void MongoStatisticsInsertRepositoryTests() {
		statisticsDataService.emptyElements();
		long inisize = statisticsDataService.countStatistics();
		statisticsDataService.insertElement(new StatisticsDTO(1,5,1));
		long endsize = statisticsDataService.countStatistics();
		statisticsDataService.emptyElements();
		assertEquals(inisize + 1, endsize);
	}

	@Test
	public void MongoStatisticsGetRepositoryNullTests() {
		statisticsDataService.emptyElements();
		assertNull(statisticsDataService.getStatistics());
	}

	@Test
	public void MongoStatisticsGetRepositoryTests() {
		statisticsDataService.emptyElements();
		statisticsDataService.insertElement(new StatisticsDTO(1,50,1));
		statisticsDataService.insertElement(new StatisticsDTO(2,500,10));
		statisticsDataService.insertElement(new StatisticsDTO(3,5000,100));
		statisticsDataService.insertElement(new StatisticsDTO(4,50000,1000));
		statisticsDataService.insertElement(new StatisticsDTO(5,500000,10000));
		statisticsDataService.insertElement(new StatisticsDTO(6,5000000,100000));
		statisticsDataService.insertElement(new StatisticsDTO(7,50000000,1000000));

		Assert.assertEquals(7,statisticsDataService.getStatistics().getCountries());

	}

}
