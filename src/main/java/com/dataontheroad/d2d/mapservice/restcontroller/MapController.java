package com.dataontheroad.d2d.mapservice.restcontroller;

import com.dataontheroad.d2d.mapservice.restcontroller.message.MapMessage;
import com.dataontheroad.d2d.mapservice.restcontroller.message.Message;
import com.dataontheroad.d2d.mapservice.restcontroller.message.PostRequest.Position;
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
    public MapMessage getElementsByPositionAndDistance(RadialMessage radialMessage) {
        return new MapMessage(mapservice.getElementsByPositionAndDistance(radialMessage));
    }

    @PostMapping("/addElement")
    public Message saveNewlements(Position position) {
        return resultMessage(mapservice.saveNewlements(position));
    }

    private Message resultMessage(boolean result){
        return (result)?new Message("Point created"):new Message("Point not created");
    }
}
