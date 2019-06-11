package com.dataontheroad.minigis.common;

import java.time.LocalDateTime;

public class BaseMessage {

    protected String type;
    protected LocalDateTime dateTime;

    public BaseMessage(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public LocalDateTime LocalDateTime(){
        return LocalDateTime.now();
    }

}
