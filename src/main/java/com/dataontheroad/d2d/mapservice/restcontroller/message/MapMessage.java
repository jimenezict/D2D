package com.dataontheroad.d2d.mapservice.restcontroller.message;

import com.dataontheroad.d2d.mapservice.services.map.MapBean;

import java.util.List;

public class MapMessage extends Message {

    private List<MapBean> mapBeans;

    public MapMessage(List<MapBean> mapBeans){
        super("Map Beans");
        this.mapBeans = mapBeans;
    }

    public List<MapBean> getMapBean(){
        return mapBeans;
    }

}
