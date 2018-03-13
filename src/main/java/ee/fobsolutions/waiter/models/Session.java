package ee.fobsolutions.waiter.models;

import org.springframework.data.annotation.Id;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Date;

/**
 * Created by FOB Solutions
 */
public class Session {

    @Id
    public String id;
    private String userId;
    private String token;
    private Date createdAt;
    private Date expiresAt;

    public Session(String userId) {
        this.userId = userId;
        this.createdAt = new Date();
        this.token = generateToken();
        this.expiresAt = Date.from(createdAt.toInstant().plus(Duration.ofHours(8)));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String generateToken() {
        SecureRandom random = new SecureRandom();
        long longToken = Math.abs(random.nextLong());
        return Long.toString(longToken, 16);
    }
}
