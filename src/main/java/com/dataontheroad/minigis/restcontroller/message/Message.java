package com.dataontheroad.minigis.restcontroller.message;

import java.time.LocalDateTime;

public class Message {

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
