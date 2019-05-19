package com.dataontheroad.d2d.mapservice;

import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import com.dataontheroad.d2d.mapservice.services.map.MapService;
import com.dataontheroad.d2d.mapservice.queryservice.MapDataService;
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

        when(mapDataService.getElementById(0)).thenReturn(new MapBean(0,0));
        when(mapDataService.getElementById(-1)).thenReturn(null);
        mapservice.setMapDataService(mapDataService);
    }

    @Test
    public void getElementById() {
        MapBean mapbean = mapservice.getElementById(0);
        assertEquals(0,mapbean.getX_cord(),0.1);
    }

    @Test
    public void getNullElementById() {
        MapBean mapbean = mapservice.getElementById(-1);
        assertNull(mapbean);
    }
}