package com.dataontheroad.minigis.map.message;

import com.dataontheroad.minigis.common.BaseMessage;
import com.dataontheroad.minigis.map.service.model.MapPointDTO;

import java.util.List;

public class MapResponse extends BaseMessage {

    private List<MapPointDTO> mapBeans;

    public MapResponse(List<MapPointDTO> mapBeans){
        super("Map Beans");
        this.mapBeans = mapBeans;
    }

    public List<MapPointDTO> getMapBean(){
        return mapBeans;
    }

}
