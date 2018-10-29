package observer;

public class AnimeNotification extends Notification {

    AnimeNotification(String notif){
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
