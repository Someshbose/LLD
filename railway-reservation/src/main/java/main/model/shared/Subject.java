package main.model.shared;

public interface Subject {
 void registerObserver(Observer ob);
 void removeObserver(Observer ob);
 void notifyObserver();
}
