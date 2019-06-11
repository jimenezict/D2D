package com.dataontheroad.minigis.map;

import com.dataontheroad.minigis.map.message.MapResponse;
import com.dataontheroad.minigis.common.BaseMessage;
import com.dataontheroad.minigis.map.message.Position;
import com.dataontheroad.minigis.map.message.RadialRequest;
import com.dataontheroad.minigis.map.service.model.MapDTO;
import com.dataontheroad.minigis.map.service.MapService;
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
    public MapResponse getElementById(@PathVariable String id){
        List<MapDTO> mapbeans = new ArrayList<>();
        mapbeans.add(mapservice.getElementById(id));
        return new MapResponse(mapbeans);
    }

    @PostMapping("/radial")
    public MapResponse getElementsByPositionAndDistance(@RequestBody RadialRequest radialMessage) {
        return new MapResponse(mapservice.getElementsByPositionAndDistance(radialMessage));
    }

    @PostMapping("/addElement")
    public BaseMessage saveNewlements(@RequestBody Position position) {
        return resultMessage(mapservice.saveNewlements(position));
    }

    private BaseMessage resultMessage(boolean result){
        return (result)?new BaseMessage("Point created"):new BaseMessage("Point not created");
    }
}
