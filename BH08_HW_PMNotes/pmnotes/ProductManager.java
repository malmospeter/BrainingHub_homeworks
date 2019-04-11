package pmnotes;

import pmnotes.documents.Task;
import pmnotes.documents.SimpleNote;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import pmnotes.documents.Document;
import pmnotes.files.Files;

public class ProductManager {

    private int id;
    private String name;
    private static int nextID = 1;

    List<SimpleNote> notes = new ArrayList<>();
    List<Task> tasks = new ArrayList<>();
    List<Files> files = new ArrayList<>();
    List<Workers> workers = new ArrayList<>();

    public ProductManager(String name) {
        this.id = nextID++;
        this.name = name;
    }

    public void listing(List<? extends Document> list) {
        if ("Files".equals(list.get(0).getClass().getSuperclass().getSimpleName())) {
            System.out.println("Files");
        } else {
            System.out.println(list.get(0).getClass().getSimpleName() + "s");
        }
        list.stream().forEach(System.out::println);
    }

    public void orderByName(List<? extends Document> list) {
        list.stream().sorted(Comparator.comparing(Document::getName)).forEach(System.out::println);
    }

    public void orderByDateCreated(List<? extends Document> list) {
        list.stream().sorted(Comparator.comparing(Document::getDateOfCreate)).forEach(System.out::println);
    }

    public void orderByNameAndDate(List<? extends Document> list) {
        list.stream().sorted(Comparator.comparing(Document::getName).thenComparing(Document::getDateOfCreate))
                .forEach(System.out::println);
    }

    public void orderByDateAndName(List<? extends Document> list) {
        list.stream().sorted(Comparator.comparing(Document::getDateOfCreate).thenComparing(Document::getName))
                .forEach(System.out::println);
    }

    public String delete(int index, List<? extends Document> list) {
        if ((list.remove(index)).getClass().getSimpleName().equals("Files")) {
            return "File are deleted!";
        } else {
            return "SimpleNote or Task are deleted!";
        }
    }

    public int searchByID(int id, List<? extends Document> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int searchByName(String name, List<? extends Document> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void createNewSimpleNote(SimpleNote sNote) {
        this.notes.add(sNote);
    }

    public void createNewTask(Task task) {
        this.tasks.add(task);
    }

    public void addWorker(Workers worker) {
        this.workers.add(worker);
    }

    public void addFile(Files file) {
        this.files.add(file);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<SimpleNote> getNotes() {
        return notes;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Files> getFiles() {
        return files;
    }

    public List<Workers> getWorkers() {
        return workers;
    }

    @Override
    public String toString() {
        return "ProductManager{" + "id=" + id + ", name=" + name + ", notes=" + notes + ", tasks=" + tasks + ", files=" + files + ", workers=" + workers + '}';
    }
}
