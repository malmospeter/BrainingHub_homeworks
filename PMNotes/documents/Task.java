package pmnotes.documents;

import java.time.LocalDate;
import java.time.Month;
import pmnotes.Workers;
import pmnotes.notification.Notification;
import pmnotes.notification.NotificationFrequency;
import pmnotes.notification.NotificationType;

public class Task extends Notes {

    private boolean completed = false;

    private Workers worker;
    private Notification notification;

    public Task(String name, String content) {
        super(name, content);
    }

    public Task(String name, String content, Workers worker) {
        super(name, content);
        this.worker = worker;
    }

    public Task(String name, String content, Workers worker, Notification notification) {
        this(name, content, worker);
        this.notification = notification;
    }

    public void addOnteTimeNotification(int year, int month, int day) {
        Notification notificationSetter = new Notification(NotificationType.ONE_TIME, LocalDate.of(year, Month.of(month), day));
        this.notification = notificationSetter;
    }

    public void addRepetedNotification(int year, int month, int day, String frequency) {
        Notification notificationSetter = new Notification(NotificationType.REPEATED, LocalDate.of(year, Month.of(month), day), NotificationFrequency.valueOf(frequency));
        this.notification = notificationSetter;
    }

    public void assignWorker(Workers worker) {
        this.worker = worker;
    }

    public void setCompleted() {
        this.completed = true;
    }

    public Workers getWorker() {
        return worker;
    }

    public Notification getNotification() {
        return notification;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return super.toString() + " completed=" + completed + " worker=" + worker + " notification=" + notification + '}';
    }
}
