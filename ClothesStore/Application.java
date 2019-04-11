package inventoryregister;

import inventoryregister.controllers.ExternalOrders;
import inventoryregister.controllers.InventoryRepository;
import inventoryregister.controllers.InventoryView;
import inventoryregister.datamodel.Accessories;
import inventoryregister.datamodel.Coat;
import inventoryregister.datamodel.CoatType;
import inventoryregister.datamodel.Gender;
import inventoryregister.datamodel.Jacket;
import inventoryregister.datamodel.JacketType;
import inventoryregister.datamodel.Others;
import java.util.ArrayList;

public class Application {

    public static void handleCompares(int i) {
        switch (i) {
            case -1:
                System.out.println("The first product is the cheaper!");
                break;
            case 0:
                System.out.println("The prizes are the same!");
                break;
            case 1:
                System.out.println("The second product is the cheaper!");
                break;
            case 100:
                System.out.println("The products type are different, You can not compare them!");
                break;
            default: ;
        }
    }

    public static void main(String[] args) {

        InventoryRepository repo = new InventoryRepository();
        InventoryView view = new InventoryView(repo.getInventoryList());
        ExternalOrders<Coat> order = new ExternalOrders(500, 3, new ArrayList<>());

        order.processOrders();

        Coat coat = new Coat(200, Gender.WOMAN, CoatType.NORMAL);
        Coat coat2 = new Coat(200, Gender.MAN, CoatType.RAINCOAT);
        Jacket jacket = new Jacket(250, Gender.MAN, JacketType.DENIM);
        Jacket jacket2 = new Jacket(275, Gender.WOMAN, JacketType.DENIM);
        Others otherStuff = new Others(50, Gender.UNISEX, "necklace");
        Accessories accessory = new Accessories(20, Gender.UNISEX, "watch");

        repo.addItem(coat);
        repo.addItem(coat2);
        repo.addItem(jacket);
        repo.addItem(jacket2);
        repo.addItem(otherStuff);
        repo.addItem(accessory);

        view.listElements();

        repo.removeItem(accessory);
        System.out.println("after removing");
        view.listElements();

        jacket.setPrice(1000);
        jacket2.setPrice(10000);
        otherStuff.setPrice(1500);
        System.out.println("After modifying prices");
        view.listElements();

        System.out.println("összehasonlítás");
        handleCompares(coat.compareTo(coat2));
        handleCompares(jacket.compareTo(jacket2));
        handleCompares(coat2.compareTo(jacket2));

    }
}
