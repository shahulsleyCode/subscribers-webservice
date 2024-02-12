package com.shahul.project.subscribers.user;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;

public class User {

    @NotEmpty(message = "Please provide a name")
    private String userId;
    @NotEmpty(message = "Please provide a name")
    private String name;
    private String accountType;
    private LocalDateTime insertTimeStamp;
    private LocalDateTime validUptoTimeStamp;

    public User(String userId, String name, String accountType, LocalDateTime insertTimeStamp, LocalDateTime validUptoTimeStamp) {
        this.userId = userId;
        this.name = name;
        this.accountType = accountType;
        this.insertTimeStamp = insertTimeStamp;
        this.validUptoTimeStamp = validUptoTimeStamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAccountType() {
        return accountType;
    }

    public LocalDateTime getInsertTimeStamp() {
        return insertTimeStamp;
    }

    public LocalDateTime getValidUptoTimeStamp() {
        return validUptoTimeStamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", insertTimeStamp=" + insertTimeStamp +
                ", validUptoTimeStamp=" + validUptoTimeStamp +
                '}';
    }
}
