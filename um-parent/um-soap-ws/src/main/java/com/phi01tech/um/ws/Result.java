package com.phi01tech.um.ws;

public class Result {
    public enum Status {
        SUCCCESS, FAILED
    }

    private Status status;

    private String description;

    public Status getStatus() {
        return status;
    }

    public Result setStatus(Status status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Result setDescription(String description) {
        this.description = description;
        return this;
    }
}
