package ee.fobsolutions.waiter.dao;

import ee.fobsolutions.waiter.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by FOB Solutions
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findById(String id);

}
