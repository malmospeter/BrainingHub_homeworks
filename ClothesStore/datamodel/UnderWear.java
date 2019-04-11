package inventoryregister.datamodel;

public class UnderWear extends Cloths {

    private boolean oneParted;

    public UnderWear(int price, Gender gender, Boolean oneParted) {
        super(price, gender);
        this.oneParted = oneParted;
    }

    public boolean isOneParted() {
        return oneParted;
    }

    public void setOneParted(boolean oneParted) {
        this.oneParted = oneParted;
    }

    @Override
    public String toString() {
        return super.toString() + "oneParted=" + oneParted + '}';
    }

}
