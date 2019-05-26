package com.dataontheroad.d2d.mapservice.repository;

import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.Position;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FountainRepositoryTests {

	@Autowired
	MapDataService mapDataService;

	@Test
	public void MongoFountainInsertRepositoryTests() {
		mapDataService.emptyElements();
		long inisize = mapDataService.countStatistics();
		ObjectId id = mapDataService.insertElement(new MapBean(0,0));
		long endsize = mapDataService.countStatistics();
		mapDataService.emptyElements();
		assertEquals(inisize + 1, endsize);
	}

	@Test
	public void MongoFountainGetLimitedResultsByVolume() {
		mapDataService.emptyElements();
		mapDataService.insertElement(new MapBean(0,0));
		mapDataService.insertElement(new MapBean(1,1));
		mapDataService.insertElement(new MapBean(2,2));
		mapDataService.insertElement(new MapBean(3,3));
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(0,0),0, 2));
		mapDataService.emptyElements();
		assertEquals(2, mapBeanList.size());
	}

	@Test
	public void MongoFountainGetLimitedResultsByLongDistance() {
		mapDataService.emptyElements();
		mapDataService.insertElement(new MapBean(0,0));
		mapDataService.insertElement(new MapBean(1,1));
		mapDataService.insertElement(new MapBean(2,2));
		mapDataService.insertElement(new MapBean(3,3));
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(0,0),100000, 2));
		mapDataService.emptyElements();
		assertEquals(2, mapBeanList.size());
	}

}
