package ee.fobsolutions.waiter.models.core;

/**
 * Created by FOB Solutions
 */
public class Response {

    private String errorMessage;
    private boolean isError;
    private Object response;

    public Response(Object response) {
        this.isError = false;
        this.errorMessage = "";
        this.response = response;
    }

    public Response(String errorMessage) {
        this.isError = true;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
