package cn.com.domain;

/**
 * @author Yan
 */
public class Food {
    private int foodid;
    private String foodname;
    private String foodsci;
    private double foodprice;
    private String foodtype;

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodsci() {
        return foodsci;
    }

    public void setFoodsci(String foodsci) {
        this.foodsci = foodsci;
    }

    public double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(double foodprice) {
        this.foodprice = foodprice;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }
}
