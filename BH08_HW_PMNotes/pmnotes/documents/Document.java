package pmnotes.documents;

import java.util.Date;

public abstract class Document {

    private String name;
    private final int ID;
    private Date dateOfCreate;

    private static int nextID = 1;

    public Document(String name) {
        this.ID = nextID++;
        this.dateOfCreate = new Date();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return ID;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "name=" + name + ", id=" + ID + ", dateOfCreate=" + dateOfCreate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.ID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Document other = (Document) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }

}
