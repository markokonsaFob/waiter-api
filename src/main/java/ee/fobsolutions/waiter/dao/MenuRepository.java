package ee.fobsolutions.waiter.dao;

import ee.fobsolutions.waiter.models.menu.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by FOB Solutions
 */
public interface MenuRepository extends MongoRepository<Menu, String> {

    Menu findById(String id);

    Menu findByName(String name);

}
