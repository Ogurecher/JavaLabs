package ru.billing.stocklist;

public class TechnicalItem extends GenericItem {
    private short warrantyTime;

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    @Override
    public void printAll(){
        System.out.printf("ID: %d; Name: %s; Price: %5.2f; Category: %s; Warranty Time: %d \n",this.getID(),this.getName(),this.getPrice(),this.getCategory(),warrantyTime);
    }
    
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        TechnicalItem toCompare = (TechnicalItem) o;
        return warrantyTime == toCompare.getWarrantyTime();
    }

    @Override
    public Object clone() {
        TechnicalItem clone = new TechnicalItem(this.getName(), this.getPrice(), this.getCategory(), this.warrantyTime);

        clone.setAnalog(this.getAnalog());

        return clone;
    }

    public String toString() {
        return super.toString() + "; Warranty time: " + warrantyTime;
    }

    public TechnicalItem(String name, float price, Category category, short warrantyTime) {
        super(name, price, category);

        this.warrantyTime = warrantyTime;
    }

    public TechnicalItem() {
    }
}