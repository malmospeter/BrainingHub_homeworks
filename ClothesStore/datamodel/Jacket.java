package inventoryregister.datamodel;

public class Jacket extends Cloths {

    private JacketType type;

    public Jacket(int price, Gender gender, JacketType type) {
        super(price, gender);
        this.type = type;
    }

    public JacketType getType() {
        return type;
    }

    public void setType(JacketType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "type=" + type + '}';
    }

}
