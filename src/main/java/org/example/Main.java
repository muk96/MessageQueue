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
        messageQueue.addSubscriber("topic1", subscriber1);
        messageQueue.addSubscriber("topic2", subscriber2);

        // Publish messages
        publisher.publish("topic1", "Hello");
        publisher.publish("topic2", "this is a message");
    }
}