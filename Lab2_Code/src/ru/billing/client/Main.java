package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws CatalogLoadException, ItemAlreadyExistsException {
        System.out.println("Lab 2");

        GenericItem[] items = new GenericItem[3];

        items[0] = new GenericItem("item1", 100, Category.GENERAL);
        items[1] = new FoodItem("item2", 200, null, new Date(), (short)7);
        items[2] = new TechnicalItem("item3", 300, Category.GENERAL, (short)7);

        for (int i = 0; i < 3; ++i) {
            items[i].printAll();
        }

        System.out.println("\nLab 2 optional:");

        FoodItem toCompare1 = new FoodItem("toCompare1");
        FoodItem toCompare2 = new FoodItem("toCompare2");
        FoodItem toCompare3 = (FoodItem) toCompare1.clone();

        System.out.println("Comparing item 1:\n" + toCompare1.toString() + "\nWith item 2:\n" + toCompare2.toString() + "\nAnd item 3:\n" + toCompare3.toString());
        System.out.printf("\nCompare 1 and 2 (not equal): %b \nCompare 1 and 3 (equal): %b\n", toCompare1.equals(toCompare2), toCompare1.equals(toCompare3));



        System.out.println("\n\nLab 3");

        String line = "Конфеты 'Маска';45;120";
        String[] item_fld = line.split(";");
        FoodItem sweets = new FoodItem(item_fld[0], Float.parseFloat(item_fld[1]), Short.parseShort(item_fld[2]));
        sweets.printAll();


        System.out.println("\n\nLab 4");

        ItemCatalog catalog = new ItemCatalog();
        for (int i = 0; i < 10; ++i) {
            GenericItem tempItem = new GenericItem(("item№" + i), (float)(i*100), Category.GENERAL);
            catalog.addItem(tempItem);
        }
        catalog.printItems();


        System.out.println("\nSpeed comparison");

        long begin = new Date().getTime();

        for(int i=0; i<10000000;i++) {
            catalog.findItemByID(10);
        }
        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end-begin)); begin = new Date().getTime();

        for(int i=0; i<10000000;i++) {
            catalog.findItemByIDAL(10);
        }
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end-begin));


        System.out.println("\nCatalogLoader: ");
        CatalogLoader loader = new CatalogStubLoader();
        loader.load(catalog);

        loader.load(catalog); //should result in an exception

        catalog.printItems();


        System.out.println("\n\nLab 6");
        loader = new CatalogFileLoader("items.list");
        catalog = new ItemCatalog();
        loader.load(catalog);
        catalog.printItems();
    }
}