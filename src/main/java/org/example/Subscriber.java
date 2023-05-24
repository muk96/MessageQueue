package org.example;

public class Subscriber {
    private String name;

    public Subscriber(String name){
        this.name = name;
    }

    public void receiveMessage(String topic, String message){
        System.out.println("Subscriber " + name + " received message : " + message + " on topic " +topic);
    }
}
