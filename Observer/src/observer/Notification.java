package observer;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

public abstract class Notification {
    protected List<Observer> observers = new ArrayList<>();

    protected void notifyObservers() {
        for(Observer o: observers){
            o.update(this);
        }
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
//        for(Iterator<Observer> it = observers.iterator(); it.hasNext();){
//            if(o == it) it.remove();
//        }
        observers.remove(o);
    }
}
