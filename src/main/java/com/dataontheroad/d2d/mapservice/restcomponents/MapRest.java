package com.dataontheroad.d2d.mapservice.restcomponents;

import com.dataontheroad.d2d.mapservice.restcomponents.message.MapMessage;
import com.dataontheroad.d2d.mapservice.restcomponents.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import com.dataontheroad.d2d.mapservice.services.map.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MapRest {

    @Autowired
    private MapService mapservice;

    @GetMapping("/map/{id}")
    @ResponseBody
    public MapMessage getElementById(@PathVariable int id){
        List<MapBean> mapbeans = new ArrayList<>();
        mapbeans.add(mapservice.getElementById(id));
        return new MapMessage(mapbeans);
    }

    @PostMapping("/map/radial")
    public MapMessage getElementsByPositionAndDistance(@RequestBody RadialMessage radialMessage) {
        List<MapBean> mapbeans = mapservice.getElementsByPositionAndDistance(radialMessage);
        return new MapMessage(mapbeans);
    }

}
