package org.example;

public class Main {
    public static void main(String[] args) {
        // Create a message queue
        MessageQueue messageQueue = new MessageQueue();

        // Create a publisher
        Publisher publisher = new Publisher(messageQueue);

        // Create subscribers
        Subscriber subscriber1 = new Subscriber("Subscriber 1");
        Subscriber subscriber2 = new Subscriber("Subscriber 2");

        // Add subscribers to the message queue
        messageQueue.addSubscriber(subscriber1);
        messageQueue.addSubscriber(subscriber2);

        // Publish messages
        publisher.publish("Hello, world!");
        publisher.publish("This is a test message.");
    }
}