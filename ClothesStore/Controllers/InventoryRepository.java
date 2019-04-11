package inventoryregister.controllers;

import inventoryregister.datamodel.Cloths;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

    private List<Cloths> inventoryList;

    public InventoryRepository() {
        inventoryList = new ArrayList<>();
    }

    public String addItem(Cloths c) {
        if (inventoryList.add(c)) {
            return "Element added!";
        } else {
            return "Could not add item!";
        }
    }

    public String removeItem(Cloths c) {
        if (inventoryList.remove(c)) {
            return "Element removed!";
        } else {
            return "Could not remove item!";
        }
    }

    public List<Cloths> getInventoryList() {
        return inventoryList;
    }

}
