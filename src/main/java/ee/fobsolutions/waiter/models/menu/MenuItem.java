package ee.fobsolutions.waiter.models.menu;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

/**
 * Created by FOB Solutions
 */
public class MenuItem {

    @Id
    public String id;
    private String name;
    private double price;
    private LocalDate createdAt;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.createdAt = LocalDate.now();
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
