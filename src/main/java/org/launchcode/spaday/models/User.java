package org.launchcode.spaday.models;
import java.util.Date;
import java.util.Objects;

public class User {
    private String username;
    private String email;
    private String password;
    private final Date joinedDate;

    private int id;
    private static int nextId = 1;
    public User() {
        this.id = nextId;
        nextId++;
        this.joinedDate = new Date();
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        public int getId() {
            return id;


    }
    public Date getJoinedDate() {
        return joinedDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
        Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword(), getId());
    }
}