package mx.mobilestudio.buscadornoticias.dto;

/**
 * Created by CGUZMANM01 on 8/22/15.
 */
public class GoogleNewsServiceResponse {

        private ResponseData responseData;
        private ResponseDetails responseDetails;
        private int responseStatus;

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    public ResponseDetails getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(ResponseDetails responseDetails) {
        this.responseDetails = responseDetails;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }
}
