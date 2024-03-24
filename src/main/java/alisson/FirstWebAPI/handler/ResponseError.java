package alisson.FirstWebAPI.handler;

import java.util.Date;

public class ResponseError {
    //The exact moment the exception is invoked
    private Date timestamp = new Date();
    //Customize according to your business
    private String status = "error";
    //Can be an error code dictionary
    private int statusCode = 400;
    //Message shown to the user
    private String error;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
