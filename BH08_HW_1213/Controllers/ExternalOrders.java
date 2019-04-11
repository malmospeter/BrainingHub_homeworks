package inventoryregister.controllers;

import com.opencsv.CSVReader;
import inventoryregister.datamodel.Cloths;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ExternalOrders<T extends Cloths> {

    private Date date;
    private int price;
    private boolean isCompleted = false;
    private int quantityOfProducts;
    private String type;

    private List<T> clothsList;

    String filePath = "C:\\FilesToJuniorJava\\coats.csv";

    public ExternalOrders(int price, int quantityOfProducts, List<T> list) {
        this.date = new Date();
        this.price = price;
        this.quantityOfProducts = quantityOfProducts;
        this.clothsList = list;
    }

    public void processOrders() {
        try {
            FileReader fr = new FileReader(filePath);
            CSVReader csv = new CSVReader(fr);
            try {
                String[] row;
                int i = 0;
                System.out.println("The external order contains the following items: ");
                while ((row = csv.readNext()) != null) {
                    for (String record : row) {
                        System.out.print(record + " ");
                    }
                    System.out.println();
                }
            } catch (IOException ex) {
                System.out.println("Something went wrong: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File cannot be found!");
        }
    }
}
