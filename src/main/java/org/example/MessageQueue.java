package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageQueue {
    Map<String, List<Subscriber>> subscribersByTopic;
    Map<String, List<String>> messagesByTopic;

    public MessageQueue(){
        subscribersByTopic = new HashMap<>();
        messagesByTopic = new HashMap<>();
    }

    void addSubscriber(String topic, Subscriber subscriber){
        if(subscribersByTopic.containsKey(topic))
        {
            List<Subscriber> subscriberList = subscribersByTopic.get(topic);
            subscriberList.add(subscriber);
        }
        else{
            List<Subscriber> subscriberList = new ArrayList<>();
            subscriberList.add(subscriber);
            subscribersByTopic.put(topic, subscriberList);
        }
    }

    void addMessage(String topic, String message){
        if(messagesByTopic.containsKey(topic)) {
            List<String> messageList = messagesByTopic.get(topic);
            messageList.add(message);
        }
        else{
            List<String> messageList = new ArrayList<>();
            messageList.add(message);
            messagesByTopic.put(topic, messageList);
        }
        notifySubscribers(topic, message);
    }

    private void notifySubscribers(String topic, String message) {
        for (Subscriber subscriber : subscribersByTopic.get(topic)) {
            Thread thread = new Thread(() -> subscriber.receiveMessage(topic, message));
            thread.start();
        }
    }
}
