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
public class MapDataRepositoryTests {

	@Autowired
	MapDataService mapDataService;

	@Test
	public void MongoMapPointInsertRepositoryTests() {
		mapDataService.emptyElements();
		long inisize = mapDataService.countStatistics();
		ObjectId id = mapDataService.insertElement(new MapBean(0,0));
		long endsize = mapDataService.countStatistics();
		mapDataService.emptyElements();
		assertEquals(inisize + 1, endsize);
	}

	@Test
	public void MongoMapPointGetLimitedResultsByVolume() {
		mapDataService.emptyElements();
		mapDataService.insertElement(new MapBean(0,0));
		mapDataService.insertElement(new MapBean(1,1));
		mapDataService.insertElement(new MapBean(2,2));
		mapDataService.insertElement(new MapBean(3,3));
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1,-1),0, 2));
		mapDataService.emptyElements();
		assertEquals(2, mapBeanList.size());
	}

	@Test
	public void MongoMapPointGetLimitedResultsByLongDistance1() {
		mapDataService.emptyElements();
		mapDataService.insertElement(new MapBean(0,0));
		mapDataService.insertElement(new MapBean(1,1));
		mapDataService.insertElement(new MapBean(2,2));
		mapDataService.insertElement(new MapBean(3,3));
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1,-1),100000000, 2));
		mapDataService.emptyElements();
		assertEquals(2, mapBeanList.size());
		assertEquals(0, mapBeanList.get(0).getX_cord(),0.1);
		assertEquals(1, mapBeanList.get(1).getX_cord(),0.1);
	}

	@Test
	public void MongoMapPointGetLimitedResultsByLongDistance2() {
		mapDataService.emptyElements();
		mapDataService.insertElement(new MapBean(0,0));
		mapDataService.insertElement(new MapBean(1,1));
		mapDataService.insertElement(new MapBean(2,2));
		mapDataService.insertElement(new MapBean(3,3));
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1,-1),100000000, 4));
		mapDataService.emptyElements();
		assertEquals(4, mapBeanList.size());
		assertEquals(0, mapBeanList.get(0).getX_cord(),0.1);
		assertEquals(3, mapBeanList.get(3).getX_cord(),0.1);
	}

	@Test
	public void MongoMapPointGetLimitedResultsByShortDistance1() {
		mapDataService.emptyElements();
		mapDataService.insertElement(new MapBean(0,0));
		mapDataService.insertElement(new MapBean(1,1));
		mapDataService.insertElement(new MapBean(2,2));
		mapDataService.insertElement(new MapBean(3,3));
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1,-1),1, 4));
		mapDataService.emptyElements();
		assertEquals(0, mapBeanList.size());
	}
}
