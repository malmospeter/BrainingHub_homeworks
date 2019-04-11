package inventoryregister.datamodel;

public class Shoe extends Cloths {

    private ShoeType type;
    private boolean waterResistant;

    public Shoe(int price, Gender gender, ShoeType type, boolean waterResistant) {
        super(price, gender);
        this.type = type;
        this.waterResistant = waterResistant;
    }

    public ShoeType getType() {
        return type;
    }

    public void setType(ShoeType type) {
        this.type = type;
    }

    public boolean isWaterResist() {
        return waterResistant;
    }

    public void setWaterResist(boolean waterResist) {
        this.waterResistant = waterResist;
    }

    @Override
    public String toString() {
        return super.toString() + "waterResist=" + waterResistant + ", type=" + type + '}';
    }

}
