package com.shahul.project.subscribers.user;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {

    @Size(min = 7, message = "userId should be 7 character Only")
    @Size(max = 7, message = "userId should be 7 character Only")
    private final String userId;

    @Size(min = 2, message = "User name should be at least 2 characters")
    @Size(max = 2, message = "User name should be at least 2 characters")
    private final String name;
    
    private final String accountType;
    private final LocalDateTime insertTimeStamp;
    private final LocalDateTime validUptoTimeStamp;

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
