package cn.com.domain;

public class Rept {
    private int reptid;//原料的ID
    private String reptname;//原料的名称
    private double reptprice;//原料的价格
    private String reptnumber;//原料的库存数量

    private String gname;//供应商的名
    private String gphone;//供应商的联系方式
    private String gaddress;//供应商的地址

    public int getReptid() {
        return reptid;
    }

    public void setReptid(int reptid) {
        this.reptid = reptid;
    }

    public String getReptname() {
        return reptname;
    }

    public void setReptname(String reptname) {
        this.reptname = reptname;
    }

    public double getReptprice() {
        return reptprice;
    }

    public void setReptprice(double reptprice) {
        this.reptprice = reptprice;
    }

    public String getReptnumber() {
        return reptnumber;
    }

    public void setReptnumber(String reptnumber) {
        this.reptnumber = reptnumber;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGphone() {
        return gphone;
    }

    public void setGphone(String gphone) {
        this.gphone = gphone;
    }

    public String getGaddress() {
        return gaddress;
    }

    public void setGaddress(String gaddress) {
        this.gaddress = gaddress;
    }
}
