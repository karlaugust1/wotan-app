package unifacear.edu.br.wotan.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.Map;

public class ServiceResponse {

    private String exceptionType;
    private String message;
    private String details;
    private Map<String, String> object;

    public ServiceResponse() {
    }

    public ServiceResponse(String exceptionType, String message, String details, Map<String, String> object) {
        this.exceptionType = exceptionType;
        this.message = message;
        this.details = details;
        this.object = object;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @JsonAnyGetter
    public Map<String, String> getObject() {
        return this.object;
    }

    @JsonAnySetter
    public void setObject (Map<String, String> object){
        this.object = object;
    }
}
