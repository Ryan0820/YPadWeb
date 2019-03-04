package cn.com.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShopingCart {
    private Map<String, ShopCartItem> foods = new HashMap<>();


    //获取商品总钱数
    public float getTotalMoney(){
        float total = 0;
        for (ShopCartItem sci : getItems()){
            total += sci.getMoney();
        }
        return total;
    }

    //获取所有信息
    public Collection<ShopCartItem> getItems(){
        return foods.values();
    }

    //清空购物车
    public void clear() {
        foods.clear();
    }

    //购物车是否为空
    public boolean isEmpty() {
        return foods.isEmpty();
    }


    //1.先检查购物车中有没有该商品,有则使其数量加1,没有新创建的shopcartitem,并加入foods中
    public void addFood(String foodid) {
        ShopCartItem sci = foods.get(foodid);

        if (null != sci) {
            sci.increment();//如果不等于空说明有购物,数量加1
        } else {
            sci = new ShopCartItem();
            foods.put(foodid, sci);
        }

    }


}
