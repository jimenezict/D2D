package com.dataontheroad.minigis.map;

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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapServiceImplGetByIdTest {

    @Autowired
    MapService mapservice;

    @Mock
    MapDataService mapDataService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(mapDataService.getElementById("0")).thenReturn(new MapPointDTO(0,0));
        when(mapDataService.getElementById("-1")).thenReturn(null);
        mapservice.setMapDataService(mapDataService);
    }

    @Test
    public void getElementById() {
        MapPointDTO mapbean = mapservice.getElementById("0");
        assertEquals(0,mapbean.getX_cord(),0.1);
    }

    @Test
    public void getNullElementById() {
        MapPointDTO mapbean = mapservice.getElementById("-1");
        assertNull(mapbean);
    }
}