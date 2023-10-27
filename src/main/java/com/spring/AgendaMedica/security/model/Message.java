package com.proyecto.faan.security.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    private String infoMessage;

    public Message(String infoMessage) {
        this.infoMessage = infoMessage;
    }

}

