package ru.billing.stocklist;

public class GenericItem {
    private int ID;
    private String name;
    private float price;
    private Category category = Category.GENERAL;
    private Object analog;

    static int currentID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Object getAnalog() {
        return analog;
    }

    public void setAnalog(Object analog) {
        this.analog = analog;
    }

    public void printAll(){
        System.out.printf("ID: %d; Name: %s; Price: %5.2f; Category: %s \n",ID,name,price,category);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GenericItem toCompare = (GenericItem) o;

        return name == toCompare.getName() && price == toCompare.getPrice() &&
                category == toCompare.getCategory() && analog == toCompare.getAnalog();
    }

    @Override
    public Object clone() {
        GenericItem clone = new GenericItem();

        clone.setName(name);
        clone.setPrice(price);
        clone.setCategory(category);
        clone.setAnalog(analog);

        return clone;
    }

    public String toString() {
        return "ID: " + ID + "; Name: " + name + "; Price: " + price + "; Category: " + category;
    }

    public GenericItem(String name, float price, Category category) {
        this();
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this();
        this.name = name;
        this.price = price;
        this.analog = analog;
    }

    public GenericItem() {
        this.ID = GenericItem.currentID++;
    }
}