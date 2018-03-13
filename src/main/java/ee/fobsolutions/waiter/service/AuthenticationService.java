package ee.fobsolutions.waiter.service;

import ee.fobsolutions.waiter.dao.SessionRepository;
import ee.fobsolutions.waiter.dao.UserRepository;
import ee.fobsolutions.waiter.models.Session;
import ee.fobsolutions.waiter.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.Date;

/**
 * Created by FOB Solutions
 */
@Service
public class AuthenticationService {

    private static final String SESSION_ID = "sessionId";
    private static final User adminUser = new User("FOB", "Admin", User.Role.ADMIN);

    @Autowired
    private UserRepository repository;

    @Autowired
    private SessionRepository sessionRepository;

    public void addAdminUser() {
        if (repository.findByUsername("FOB") == null) {
            repository.save(adminUser);
        }
    }

    User getUser(String userId) {
        return repository.findById(userId);
    }

    private Session login(String username, String password) {
        User user = repository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return sessionRepository.save(new Session(user.getId()));
        } else {
            return null;
        }
    }

    public Session authenticate(String username, String password, HttpServletRequest request) {
        if (!isLoggedIn(request)) {
            return login(username, password);
        } else if (!getLoggedInUser(request).getUsername().equals(username)) {
            logout(request);
            return login(username, password);
        } else {
            return getSession(request);
        }
    }

    public Session logout(HttpServletRequest request) {
        Session session = getSession(request);
        if (session != null) {
            session.setExpiresAt(Date.from(new Date().toInstant().minus(Duration.ofSeconds(1))));
            sessionRepository.save(session);
        }
        return session;
    }

    public User register(String username, String password, String password2, User.Role role) {
        User user = null;
        if (password.equals(password2) && repository.findByUsername(username) == null) {
            user = new User(username, password, role);
            user = repository.save(user);
        }
        return user;
    }

    public User update(String id, String password, String password2, User.Role role) {
        User user = repository.findById(id);
        if (password.equals(password2)) {
            user.setPassword(password);
            user.setRole(role);
        }
        return repository.save(user);
    }

    public void reset() {
        repository.deleteAll();
        sessionRepository.deleteAll();
    }

    public boolean isLoggedIn(HttpServletRequest request) {
        boolean isLoggedIn = false;
        try {
            Session session = getSession(request);
            isLoggedIn = (session != null && session.getExpiresAt().after(new Date()));
        } catch (Exception ignored) {

        }
        return isLoggedIn;
    }

    public boolean isAdmin(HttpServletRequest request) {
        Session session = getSession(request);
        if (session != null) {
            User user = repository.findById(session.getUserId());
            return user != null && user.getRole() == User.Role.ADMIN;
        } else {
            return false;
        }
    }

    public boolean isWaiter(HttpServletRequest request) {
        Session session = getSession(request);
        if (session != null) {
            User user = repository.findById(session.getUserId());
            return user != null && user.getRole() == User.Role.WAITER;
        } else {
            return false;
        }
    }

    public User getLoggedInUser(HttpServletRequest request) {
        Session session = getSession(request);
        if (session != null) {
            return repository.findById(getSession(request).getUserId());
        } else {
            return null;
        }
    }

    Session getSession(HttpServletRequest request) {
        return sessionRepository.findByToken(request.getHeader(SESSION_ID));
    }
}
