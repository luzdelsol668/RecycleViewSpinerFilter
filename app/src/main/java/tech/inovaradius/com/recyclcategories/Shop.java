package tech.inovaradius.com.recyclcategories;

public class Shop {


    String name;
    int price;
    String catego;

    public Shop(String name, int price, String catego) {
        this.name = name;
        this.price = price;
        this.catego = catego;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCatego() {
        return catego;
    }

    public void setCatego(String catego) {
        this.catego = catego;
    }
}
