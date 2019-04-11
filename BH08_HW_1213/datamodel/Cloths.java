package inventoryregister.datamodel;

public abstract class Cloths implements Comparable<Cloths> {

    protected int price;
    protected Gender gender;

    public Cloths(int price, Gender gender) {
        this.price = price;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.price;
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
        final Cloths other = (Cloths) obj;
        if (this.price != other.price) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Cloths o) {
        if (o.getClass().getName().equals(this.getClass().getName())) {
            if (this.price == o.getPrice()) {
                return 0;
            } else if (this.price < o.getPrice()) {
                return -1;
            } else {
                return 1;
            }
        }
        return 100;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "price=" + price + ", gender=" + gender + ", ";
    }

}
