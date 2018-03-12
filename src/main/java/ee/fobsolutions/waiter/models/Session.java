package ee.fobsolutions.waiter.models;

import org.springframework.data.annotation.Id;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by FOB Solutions
 */
public class Session {

    @Id
    public String id;
    private String userId;
    private String token;
    private LocalDate createdAt;
    private LocalDate expiresAt;

    public Session(String userId) {
        this.userId = userId;
        this.createdAt = LocalDate.now();
        this.token = generateToken();
        this.expiresAt = createdAt.plusDays(1);
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDate expiresAt) {
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
