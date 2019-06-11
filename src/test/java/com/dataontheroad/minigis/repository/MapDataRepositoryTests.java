package com.dataontheroad.minigis.repository;

import com.dataontheroad.minigis.restcontroller.message.PostRequest.Position;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.minigis.services.map.MapBean;
import org.junit.After;
import org.junit.Before;
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

	@Before
	public void init(){
		mapDataService.emptyElements();
		mapDataService.insertElement(new MapBean(0,0));
		mapDataService.insertElement(new MapBean(1,1));
		mapDataService.insertElement(new MapBean(2,2));
		mapDataService.insertElement(new MapBean(3,3));
	}

	@Test
	public void MongoMapPointGetLimitedResultsByVolume() {
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1.0,-1.0),0, 2));
		assertEquals(2, mapBeanList.size());
	}

	@Test
	public void MongoMapPointGetLimitedResultsByLongDistance1() {
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1.0,-1.0),100000000, 2));
		assertEquals(2, mapBeanList.size());
		assertEquals(0, mapBeanList.get(0).getX_cord(),0.1);
		assertEquals(1, mapBeanList.get(1).getX_cord(),0.1);
	}

	@Test
	public void MongoMapPointGetLimitedResultsByLongDistance2() {
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1.0,-1.0),100000000, 4));
		assertEquals(4, mapBeanList.size());
		assertEquals(0, mapBeanList.get(0).getX_cord(),0.1);
		assertEquals(3, mapBeanList.get(3).getX_cord(),0.1);
	}

	@Test
	public void MongoMapPointGetLimitedResultsByShortDistance1() {
		List<MapBean> mapBeanList = mapDataService
				.getElementsByPositionAndDistance(new RadialMessage(new Position(-1.0,-1.0),1, 4));
		assertEquals(0, mapBeanList.size());
	}

	@After
	public void finish(){
		mapDataService.emptyElements();
	}
}
