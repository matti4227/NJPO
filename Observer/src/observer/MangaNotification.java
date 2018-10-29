package observer;

public class MangaNotification extends Notification {

    MangaNotification(String notif){
        this.notif = notif;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
        notifyObservers();
    }

    private String notif = "";
}
