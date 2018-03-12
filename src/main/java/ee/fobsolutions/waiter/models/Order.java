package ee.fobsolutions.waiter.models;

import ee.fobsolutions.waiter.models.menu.MenuItem;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FOB Solutions
 */
public class Order {

    public enum Status {
        WAITING,
        INPROGRESS,
        DELIVERED,
        CANCELLED
    }

    @Id
    public String id;
    private Status status;
    private String customerId;
    private String waiterId;
    private List<MenuItem> items;

    public Order(String customerId, String waiterId) {
        this.status = Status.WAITING;
        this.customerId = customerId;
        this.waiterId = waiterId;
        this.items = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void addItemToOrder(MenuItem item) {
        this.items.add(item);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }
}
