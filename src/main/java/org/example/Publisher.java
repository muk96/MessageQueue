package org.example;

public class Publisher {
    MessageQueue messageQueue;

    public Publisher(MessageQueue messageQueue){
        this.messageQueue = messageQueue;
    }

    void publish(String message){
        messageQueue.addMessage(message);
    }
}
