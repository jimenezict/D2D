package com.dataontheroad.minigis.service.map;

import com.dataontheroad.minigis.map.message.Position;
import com.dataontheroad.minigis.map.message.RadialRequest;
import com.dataontheroad.minigis.map.repository.service.MapDataService;
import com.dataontheroad.minigis.map.service.model.MapPointDTO;
import com.dataontheroad.minigis.map.service.MapService;
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

        List<MapPointDTO> listMapBean = new ArrayList<>();
        listMapBean.add(new MapPointDTO(2.3,2.3));

        when(mapDataService.getElementsByPositionAndDistance(any())).thenReturn(listMapBean);
        mapservice.setMapDataService(mapDataService);
    }

    @Test
    public void getElementById() {
        RadialRequest radialMessage = new RadialRequest(new Position(2.3,2.3), 10, 10);
        List<MapPointDTO> mapbean = mapservice.getElementsByPositionAndDistance(radialMessage);
        assertEquals(1,mapbean.size());
    }

}