package com.dataontheroad.d2d.mapservice.restcontroller.message;

import java.time.LocalDateTime;

public abstract class Message {

    protected String type;
    protected LocalDateTime dateTime;

    public Message(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public LocalDateTime LocalDateTime(){
        return LocalDateTime.now();
    }

}
