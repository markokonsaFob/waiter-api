package ee.fobsolutions.waiter.models.menu;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by FOB Solutions
 */
public class MenuItem {

    @Id
    public String id;
    private String name;
    private double price;
    private Date createdAt;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.createdAt = new Date();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
