package cn.com.domain;


/**
 * 购物车中的商品,包含对商品的引用和商品的数量
 */
public class ShopCartItem {

    public Food food;  //商品
    private int quantity; //数量


    //返回钱数,合计总价
    public double getMoney(){
        return food.getFoodprice()*quantity;
    }



    //商品数量加1
   public void increment(){
       quantity++;
   }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
