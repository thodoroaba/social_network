package com.socialnetwork.app.model;

import java.util.Date;

public class User {

    private String id;
    private String username;
    private String password;
    private String profilePic;
    private String emailAddress;
    private Date registeredOn;

    public User(String id, String username, String password, String profilePic, String emailAddress, Date registeredOn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.profilePic = profilePic;
        this.emailAddress = emailAddress;
        this.registeredOn = registeredOn;
    }

    public class UserBuilder {
        private String id;
        private String username;
        private String password;
        private String profilePic;
        private String emailAddress;
        private Date registeredOn;

        public User build() {
            return new User(id, username, password, profilePic, emailAddress, registeredOn);
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
