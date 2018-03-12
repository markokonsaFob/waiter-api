package ee.fobsolutions.waiter.dao;

import ee.fobsolutions.waiter.models.Session;
import ee.fobsolutions.waiter.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by FOB Solutions
 */
public interface SessionRepository extends MongoRepository<Session, String> {

    Session findById(String id);

    Session findByToken(String token);

}
