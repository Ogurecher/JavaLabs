package ru.billing.stocklist;

import java.util.Calendar;
import java.util.Date;

public class FoodItem extends GenericItem {
    private Date dateOfIncome;
    private short expires;

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }

    @Override
    public void printAll(){
        System.out.printf("ID: %d; Name: %s; Price: %5.2f; Category: %s; Date of income: %s; Expires in: %d \n",this.getID(),this.getName(),this.getPrice(),this.getCategory(),this.getDateOfIncome(),this.getExpires());
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) {
            return false;
        }
        FoodItem toCompare = (FoodItem) o;
        Calendar thisDate = Calendar.getInstance();
        if (dateOfIncome != null) {
            thisDate.setTime(dateOfIncome);
        }

        Calendar dateToCompare = Calendar.getInstance();
        if (toCompare.getDateOfIncome() != null) {
            dateToCompare.setTime(toCompare.getDateOfIncome());
        }
        return super.equals(o) && expires == toCompare.getExpires() && thisDate.get(Calendar.DAY_OF_MONTH) == dateToCompare.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public Object clone() {
        FoodItem clone = new FoodItem(this.getName(), this.getPrice(), (FoodItem) this.getAnalog(), dateOfIncome, expires);

        clone.setCategory(this.getCategory());

        return clone;
    }

    public String toString() {
        return super.toString() + "; Date of income: " + dateOfIncome + "; Expires in: " + expires;
    }

    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        super(name, price, analog);
        this.dateOfIncome = date;
        this.expires = expires;
    }
    public FoodItem(String name, float price, short expires) {
        this(name, price, null, null, expires);
    }
    public FoodItem(String name) {
        this(name, 0, (short)0);
    }

}