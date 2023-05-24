package org.example;

import java.util.ArrayList;
import java.util.List;


public class MessageQueue {
    List<Subscriber> subscribers;
    List<String> messages;

    public MessageQueue(){
        subscribers = new ArrayList<>();
        messages = new ArrayList<>();
    }

    void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    void addMessage(String message){
        messages.add(message);
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveMessage(messages.get(messages.size() - 1));
        }
    }
}
