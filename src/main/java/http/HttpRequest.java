package http;

import server.config.HttpConfigurationException;

public class HttpRequest extends HttpMessage{

    private HttpMethod method;
    private String requestTarget;
    private String originalHttpVersion; //literal from the request
    private HttpVersion bestCompatibleVersion;

    public HttpRequest() {
    }


    public HttpMethod getMethod() {
        return method;
    }

    public String getRequestTarget() {
        return requestTarget;
    }

    public HttpVersion getBestCompatibleVersion() {
        return bestCompatibleVersion;
    }

    public String getOriginalHttpVersion() {
        return originalHttpVersion;
    }

    void setMethod(String methodName) throws HttpParsingException {
        for(HttpMethod method : HttpMethod.values()) {
            if(methodName.equals(method.name())) {
                this.method = HttpMethod.valueOf(methodName);
                return;
            }
        }
        throw new HttpParsingException(HttpStatusCode.SERVER_ERROR_501_NOT_IMPLEMENTED);

    }

    void setRequestTarget(String requestTarget) throws HttpParsingException {
        if(requestTarget == null ||requestTarget.length() == 0) {
            throw new HttpParsingException(HttpStatusCode.SERVER_ERROR_500_INTERNAL_SERVER_ERROR);
        }
        this.requestTarget = requestTarget;
    }

    void setHttpVersion(String originalHttpVersion) throws HttpParsingException, BadHttpVesionException {
        this.originalHttpVersion = originalHttpVersion;
        this.bestCompatibleVersion = HttpVersion.getBestCompatibleVersion(originalHttpVersion);
        if(bestCompatibleVersion == null) {
            throw new HttpParsingException(HttpStatusCode.SERVER_ERROR_505_HTTP_VERSION_NOT_SUPPORTED);
        }
    }


}
