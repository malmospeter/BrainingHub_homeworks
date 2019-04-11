package pmnotes;

public class Workers {

    private String name;
    private final int ID;

    private static int nextID = 1;

    public Workers(String name) {
        this.ID = nextID++;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    public String getName() {
        return name;
    }

    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "Workers{" + "name=" + name + ", id=" + ID + '}';
    }
    
}
