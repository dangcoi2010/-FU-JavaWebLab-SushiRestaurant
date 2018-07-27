/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Windows 10 Version 2
 */
public class Product {
    private int pid;
    private String pname;
    private double price;
    private String image;
    private String desc;
    private String short_desc;

    public Product(int pid, String pname, double price, String image, String desc, String short_desc) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.image = image;
        this.desc = desc;
        this.short_desc = short_desc;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }
    
    
}
