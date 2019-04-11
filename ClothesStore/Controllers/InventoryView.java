package inventoryregister.controllers;

import inventoryregister.datamodel.Cloths;
import java.util.List;

public class InventoryView {
    
    private List<Cloths> inventory;

    public InventoryView(List<Cloths> inventory) {
        this.inventory = inventory;
    }
    
    public void listElements() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).toString());
        }
    }
}
