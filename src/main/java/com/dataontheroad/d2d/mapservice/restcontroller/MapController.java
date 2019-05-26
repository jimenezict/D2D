package com.dataontheroad.d2d.mapservice.restcontroller;

import com.dataontheroad.d2d.mapservice.restcontroller.message.MapMessage;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.d2d.mapservice.services.map.MapBean;
import com.dataontheroad.d2d.mapservice.services.map.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/map")
public class MapController {

    @Autowired
    private MapService mapservice;

    @GetMapping("/{id}")
    @ResponseBody
    public MapMessage getElementById(@PathVariable String id){
        List<MapBean> mapbeans = new ArrayList<>();
        mapbeans.add(mapservice.getElementById(id));
        return new MapMessage(mapbeans);
    }

    @PostMapping("/radial")
    public MapMessage getElementsByPositionAndDistance(@RequestBody RadialMessage radialMessage) {
        List<MapBean> mapbeans = mapservice.getElementsByPositionAndDistance(radialMessage);
        return new MapMessage(mapbeans);
    }

}
