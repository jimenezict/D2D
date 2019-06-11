package com.dataontheroad.minigis.restcontroller;

import com.dataontheroad.minigis.restcontroller.message.MapMessage;
import com.dataontheroad.minigis.common.BaseMessage;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.Position;
import com.dataontheroad.minigis.restcontroller.message.PostRequest.RadialMessage;
import com.dataontheroad.minigis.services.map.MapBean;
import com.dataontheroad.minigis.services.map.MapService;
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
        return new MapMessage(mapservice.getElementsByPositionAndDistance(radialMessage));
    }

    @PostMapping("/addElement")
    public BaseMessage saveNewlements(@RequestBody Position position) {
        return resultMessage(mapservice.saveNewlements(position));
    }

    private BaseMessage resultMessage(boolean result){
        return (result)?new BaseMessage("Point created"):new BaseMessage("Point not created");
    }
}
