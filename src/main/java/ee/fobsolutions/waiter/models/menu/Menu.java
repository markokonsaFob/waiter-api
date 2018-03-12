package ee.fobsolutions.waiter.models.menu;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FOB Solutions
 */
public class Menu {

    @Id
    public String id;
    private String name;
    private List<MenuItem> menuItems;
    private LocalDate createdAt;

    public Menu(String name) {
        this.name = name;
        this.createdAt = LocalDate.now();
        this.menuItems = new ArrayList<>();
    }

    public void addToMenu(MenuItem item) {
        menuItems.add(item);
    }

    public void addItems(List<MenuItem> items) {
        this.menuItems = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
