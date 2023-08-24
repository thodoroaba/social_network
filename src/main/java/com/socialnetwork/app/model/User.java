package com.socialnetwork.app.model;

import java.util.Date;

public class User {

    private String id;
    private String username;
    private String password;
    private String profilePic;
    private String emailAddress;
    private Date registeredOn;

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.getId();
        this.username = userBuilder.getUsername();
        this.password = userBuilder.getPassword();
        this.profilePic = userBuilder.getProfilePic();
        this.emailAddress = userBuilder.getEmailAddress();
        this.registeredOn = userBuilder.getRegisteredOn();
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", registeredOn=" + registeredOn +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public static class UserBuilder {
        private String id;
        private String username;
        private String password;
        private String profilePic;
        private String emailAddress;
        private Date registeredOn;

        public User build() {
            return new User(this);
        }

        public String getId() {
            return id;
        }

        public UserBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public String getUsername() {
            return username;
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public String getProfilePic() {
            return profilePic;
        }

        public UserBuilder setProfilePic(String profilePic) {
            this.profilePic = profilePic;
            return this;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public UserBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Date getRegisteredOn() {
            return registeredOn;
        }

        public UserBuilder setRegisteredOn(Date registeredOn) {
            this.registeredOn = registeredOn;
            return this;
        }

    }
}
