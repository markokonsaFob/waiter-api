package ee.fobsolutions.waiter.dao;

import ee.fobsolutions.waiter.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by FOB Solutions
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findById(String id);

    User findByUsername(String username);

}
