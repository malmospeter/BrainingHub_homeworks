package inventoryregister.datamodel;

public class Coat extends Cloths {

    private CoatType type;

    public Coat(int price, Gender gender, CoatType type) {
        super(price, gender);
        this.type = type;
    }

    public CoatType getType() {
        return type;
    }

    public void setType(CoatType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "type=" + type + '}';
    }

}
