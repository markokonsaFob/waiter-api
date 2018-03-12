package ee.fobsolutions.waiter.dao;

import ee.fobsolutions.waiter.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by FOB Solutions
 */
public interface OrderRepository extends MongoRepository<Order, String> {

    Order findById(String id);

}
