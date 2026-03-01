package BehavioralDesignPatttern;

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String video);
}

class YouTubeSubscriber implements Subscriber {
    private String name;

    YouTubeSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String video) {
        System.out.println("YT Notification ->" + video + name);
    }
}

class EmailSubscriber implements Subscriber {
    private String email;

    EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String video) {
        System.out.println("Email Notification ->" + video + email);
    }
}

interface YouTubeChannel {
    void addSubscriber(Subscriber subscriber);

    void removeSubscriber(Subscriber subscriber);

    void notifySubscribers();
}

class YouTubeChannelImpl implements YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String video;

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber); // Add a subscriber to the channel
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber); // Remove a subscriber from the channel
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(video); // Call update() for each subscriber
        }
    }

    public void uploadNewVideo(String video) {
        this.video = video; // Set the video that is being uploaded
        notifySubscribers(); // Notify all subscribers about the new video
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        YouTubeChannelImpl channel = new YouTubeChannelImpl();
        YouTubeSubscriber alice = new YouTubeSubscriber("Alice");
        EmailSubscriber bob = new EmailSubscriber("Bob");

        channel.addSubscriber(alice);
        channel.addSubscriber(bob);

        channel.uploadNewVideo("Java Tutorial.....");
    }
}