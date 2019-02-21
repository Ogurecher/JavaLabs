package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistsException;

import java.util.HashMap;
import java.util.ArrayList;

public  class ItemCatalog {
    private HashMap <Integer, GenericItem> catalog = new HashMap <Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        try {
            if (catalog.containsValue(item)) {
                throw new ItemAlreadyExistsException();
            }
            catalog.put(item.getID(), item); // Добавляем товар в HashMap
            ALCatalog.add(item); // Добавляем тот же товар в ArrayList
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    public void printItems(){
        for(GenericItem i : ALCatalog){
            System.out.println(i.toString());
        }
    }

    public GenericItem findItemByID(int id){
        if(!catalog.containsKey(id)) {
            return null;
        } else{
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id){
        for(GenericItem i : ALCatalog){
            if(i.getID()==id) return i;
        }
        return null;
    }


}