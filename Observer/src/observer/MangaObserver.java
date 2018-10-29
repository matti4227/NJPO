package observer;

public class MangaObserver implements Observer{

    private MangaNotification notification;

    public MangaObserver(MangaNotification notification){

        this.notification = notification;
        this.notification.addObserver(this);
    }

    @Override
    public void update(Notification notification) {
        if(this.notification == notification)
            System.out.println("New Manga Chapter: " + this.notification.getNotif());
    }
}
