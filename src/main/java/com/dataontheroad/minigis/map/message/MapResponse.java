package com.dataontheroad.minigis.map.message;

import com.dataontheroad.minigis.common.BaseMessage;
import com.dataontheroad.minigis.map.service.model.MapDTO;

import java.util.List;

public class MapResponse extends BaseMessage {

    private List<MapDTO> mapBeans;

    public MapResponse(List<MapDTO> mapBeans){
        super("Map Beans");
        this.mapBeans = mapBeans;
    }

    public List<MapDTO> getMapBean(){
        return mapBeans;
    }

}
