package ee.fobsolutions.waiter.dao;

import ee.fobsolutions.waiter.models.menu.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by FOB Solutions
 */
public interface MenuItemRepository extends MongoRepository<MenuItem, String> {

    MenuItem findById(String id);
}
