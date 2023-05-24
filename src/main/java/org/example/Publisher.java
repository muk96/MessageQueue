package org.example;

public class Publisher {
    MessageQueue messageQueue;

    public Publisher(MessageQueue messageQueue){
        this.messageQueue = messageQueue;
    }

    void publish(String topic, String message){
        messageQueue.addMessage(topic, message);
    }
}
