package pmnotes.notification;

import java.time.LocalDate;

public class Notification {

    NotificationType type;
    NotificationFrequency frequency;
    LocalDate notifyDate;

    public Notification(NotificationType type, LocalDate date) {
        this.type = type;
        this.notifyDate = date;
    }
    
    public Notification(NotificationType type, LocalDate date, NotificationFrequency frequency) {
        this.type = type;
        this.frequency = frequency;
        this.notifyDate = date;
    }

    @Override
    public String toString() {
        return "Notification{" + "type=" + type + ", frequency=" + frequency + ", notifyDate=" + notifyDate + '}';
    }

    
}
