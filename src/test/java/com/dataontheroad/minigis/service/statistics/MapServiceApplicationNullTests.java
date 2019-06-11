package com.dataontheroad.minigis.service.statistics;

import com.dataontheroad.minigis.repository.StatisticsDataService;
import com.dataontheroad.minigis.restcontroller.message.StatisticsMessage;
import com.dataontheroad.minigis.services.statistics.Statistics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapServiceApplicationNullTests {

	@Autowired
    Statistics statistics;

	@Mock
    StatisticsDataService statisticsDataService;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		when(statisticsDataService.getStatistics()).thenReturn(null);
		statistics.setStatisticsDataService(statisticsDataService);
	}

	@Test
	public void StatisticsImpl() {
		assertEquals(0,statistics.getStatistics().getCountries());
	}

	@Test
	public void StatisticsMessage() {
		StatisticsMessage sm = new StatisticsMessage(statistics.getStatistics());
		assertEquals("Statistic",sm.getType());
	}
}