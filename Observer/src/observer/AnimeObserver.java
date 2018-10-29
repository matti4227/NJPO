package observer;

public class AnimeObserver implements Observer {

    private AnimeNotification notification;

    public AnimeObserver(AnimeNotification notification) {

        this.notification = notification;
        this.notification.addObserver(this);
    }
    @Override
    public void update(Notification notification) {
        if(this.notification == notification)
            System.out.println("New Anime Episode: " + this.notification.getNotif());
    }
}
