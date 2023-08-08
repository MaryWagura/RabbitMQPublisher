package com.rabbitmq.rabbitmq;

import lombok.Data;

import java.io.Serializable;

@Data
public class SimpleMessage implements Serializable {
    private String name;
    private String description;

    public SimpleMessage(){
    }

    @Override
    public String toString(){
        return "SimpleMessage{" +
                "name='" + name + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}
