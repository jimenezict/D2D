package com.dataontheroad.minigis.service.statistics;

import com.dataontheroad.minigis.statistics.repository.StatisticsDataService;
import com.dataontheroad.minigis.statistics.message.StatisticsMessage;
import com.dataontheroad.minigis.statistics.service.Statistics;
import com.dataontheroad.minigis.statistics.service.StatisticsBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapServiceApplicationTests {

	@Autowired
    Statistics statistics;

	@Mock
    StatisticsDataService statisticsDataService;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		when(statisticsDataService.getStatistics()).thenReturn(new StatisticsBean(3,300,5));
		statistics.setStatisticsDataService(statisticsDataService);
	}

	@Test
	public void StatisticsImpl() {
		assertEquals(3,statistics.getStatistics().getCountries());
	}

	@Test
	public void StatisticsMessage() {
		StatisticsMessage sm = new StatisticsMessage(statistics.getStatistics());
		assertEquals("Statistic",sm.getType());
	}
}
