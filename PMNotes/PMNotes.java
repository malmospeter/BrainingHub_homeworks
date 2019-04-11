package pmnotes;

import java.util.List;
import java.util.Scanner;
import pmnotes.documents.Document;
import pmnotes.documents.SimpleNote;
import pmnotes.documents.Task;
import pmnotes.files.Files;

public class PMNotes {

    static int input;
    static String managerName;
    static Scanner sc = new Scanner(System.in);

    static ProductManager pm;

    public static int mainMenu() {
        System.out.println("Please enter what You want to do: ");
        do {
            System.out.println("0) QUIT");
            System.out.println("1) Create new note/task");
            System.out.println("2) Modify note/task");
            System.out.println("3) Delete note/task");
            System.out.println("4) List notes/tasks");
            System.out.println("5) Upload file");
            System.out.println("6) Add workers");
            input = sc.nextInt();
        } while (input < 0 || input > 6);
        return input;
    }

    public static int subMenu(int mainMenu) {
        if (input > 0 && input < 5) {
            do {
                System.out.println("Note (1) or Task (2)? ");
                input = sc.nextInt();
            } while (!(input == 1 || input == 2));
            return input;
        }
        return input = 0;
    }

    public static int menuForlistingBy() {
        int listingType;
        System.out.println("Please enter what kind of list You want to see: ");
        do {
            System.out.println("1) Original(inputs) order");
            System.out.println("2) List by name");
            System.out.println("3) List by date created");
            System.out.println("4) List by name and date");
            System.out.println("5) List by date and name");
            listingType = sc.nextInt();
        } while (listingType < 1 || listingType > 5);
        return listingType;
    }

    public static int endOfRun(int endSign) {
        return (endSign == 0) ? -1 : 0;
    }

    public static void communicateWithUser() throws Exception {
        int choosenMenu = 0;

        do {
            mainMenu();
            choosenMenu += 10 * input;
            subMenu(input);
            choosenMenu += input;
            input = 0;
            System.out.println(choosenMenu);

            action(choosenMenu);

            choosenMenu = endOfRun(choosenMenu);

        } while (choosenMenu != -1);
    }

    public static void listing(int type, List<? extends Document> list) {
        switch (type) {
            case 1:
                pm.listing(list);
                break;
            case 2:
                pm.orderByName(list);
                break;
            case 3:
                pm.orderByDateCreated(list);
                break;
            case 4:
                pm.orderByNameAndDate(list);
                break;
            case 5:
                pm.orderByDateAndName(list);
                break;
            default: ;
        }
    }

    public static void deleting(List<? extends Document> list) {
        System.out.print("Enter ID which You want to delete OR enter 0 to skip: ");
        int id = sc.nextInt();
        if (id != 0 && pm.searchByID(id, list) != -1) {
            System.out.println(pm.delete(pm.searchByID(id, list), list));
        } else {
            System.out.println("You skiped deletion, or the entered ID doesn't exist!");
        }
    }

    public static void action(int workNumber) throws Exception {
        if (workNumber == 60) {//adding a worker
            System.out.print("Enter worker's name: ");
            String workersName = sc.nextLine();
            pm.addWorker(new Workers(workersName));

        } else if (workNumber == 50) {//upload a file
            int fileType;
            do {
                System.out.print("Enter type of file (1) PDF; 2) Video ; 3) Voice): ");
                fileType = sc.nextInt();
            } while (fileType < 1 || fileType > 3);

            System.out.print("Enter file's name: ");
            String fileName = sc.nextLine();
            pm.files.add(Files.uploadFile(fileType, fileName));

        } else if (workNumber == 41) {//listing notes
            int type = menuForlistingBy();
            listing(type, pm.notes);

        } else if (workNumber == 42) {//listing tasks
            int type = menuForlistingBy();
            listing(type, pm.tasks);

        } else if (workNumber == 31) { //deleting note
            deleting(pm.notes);

        } else if (workNumber == 32) { //deleting task
            deleting(pm.tasks);

        } else if (workNumber == 21) { //modifying note
            pm.listing(pm.notes);
            System.out.print("Enter ID of note which You want to modify OR enter 0 to skip: ");
            int id = sc.nextInt();
            if (id != 0) {
                System.out.println(pm.notes.get(pm.searchByID(id, pm.notes)).toString());
                System.out.print("Enter new name! If You don't want to change, enter q");
                String modifiedName = sc.next();
                if (!modifiedName.equalsIgnoreCase("q")) {
                    pm.notes.get(pm.searchByID(id, pm.notes)).setName(modifiedName);
                }
                System.out.print("Enter new content! If You don't want to change, enter q");
                String modifiedContent = sc.next();
                if (!modifiedContent.equals("q")) {
                    pm.notes.get(pm.searchByID(id, pm.notes)).setContent(modifiedContent);
                }
            }

        } else if (workNumber == 22) {//modifying task
            pm.listing(pm.tasks);
            System.out.print("Enter ID of task which You want to modify OR enter 0 to skip: ");
            int id = sc.nextInt();
            if (id != 0) {
                System.out.println(pm.tasks.get(pm.searchByID(id, pm.tasks)).toString());
                System.out.print("Enter new name! If You don't want to change, enter q");
                String modifiedName = sc.next();
                if (!modifiedName.equalsIgnoreCase("q")) {
                    pm.tasks.get(pm.searchByID(id, pm.tasks)).setName(modifiedName);
                }
                System.out.print("Enter new content! If You don't want to change, enter q");
                String modifiedContent = sc.next();
                if (!modifiedContent.equals("q")) {
                    pm.tasks.get(pm.searchByID(id, pm.tasks)).setContent(modifiedContent);
                }
            }

        } else if (workNumber == 11) {
            System.out.print("Enter note's name: ");
            String name = sc.next();
            System.out.print("Enter note's content: ");
            String content = sc.next();
            pm.createNewSimpleNote(new SimpleNote(name, content));

        } else if (workNumber == 12) {
            System.out.print("Enter task's name: ");
            String name = sc.next();
            System.out.print("Enter task's content: ");
            String content = sc.next();
            pm.createNewTask(new Task(name, content));
        }
    }

    public static void main(String[] args) {

        try {
            System.out.print("Please, enter Your name: ");
            managerName = sc.nextLine();

            pm = new ProductManager(managerName);

            System.out.println("Welcome " + pm.getName() + "!");

            communicateWithUser();
        } catch (Exception ex) {
            System.out.println("Something went wrong! :(");
        }
    }
}
