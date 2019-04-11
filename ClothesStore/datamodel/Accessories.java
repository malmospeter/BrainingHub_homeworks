package inventoryregister.datamodel;

public class Accessories extends Cloths {

    private String name;

    public Accessories(int price, Gender gender, String name) {
        super(price, gender);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + "name=" + name + '}';
    }

}
