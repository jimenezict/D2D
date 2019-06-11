package com.dataontheroad.minigis.service.map;

import com.dataontheroad.minigis.repository.MapDataService;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.Position;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.minigis.services.map.MapBean;
import com.dataontheroad.minigis.services.map.MapService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapServiceImplElementByPositionTest {

    @Autowired
    MapService mapservice;

    @Mock
    MapDataService mapDataService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        List<MapBean> listMapBean = new ArrayList<>();
        listMapBean.add(new MapBean(2.3,2.3));

        when(mapDataService.getElementsByPositionAndDistance(any())).thenReturn(listMapBean);
        mapservice.setMapDataService(mapDataService);
    }

    @Test
    public void getElementById() {
        RadialMessage radialMessage = new RadialMessage(new Position(2.3,2.3), 10, 10);
        List<MapBean> mapbean = mapservice.getElementsByPositionAndDistance(radialMessage);
        assertEquals(1,mapbean.size());
    }

}