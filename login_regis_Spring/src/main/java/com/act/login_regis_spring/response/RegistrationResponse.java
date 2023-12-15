package com.act.login_regis_spring.response;

public class RegistrationResponse {
    String message;
    Boolean status;

    public RegistrationResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public RegistrationResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
