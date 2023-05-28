package http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser;

    @BeforeAll
    public void beforeClass() {
        httpParser = new HttpParser();
    }

    @Test
    void parseHttpRequest()  {
        HttpRequest httpRequest = null;
        try {
            httpRequest = httpParser.parseHttpRequest(generateValidGETTestCase());
        } catch (HttpParsingException e) {
            fail(e);
        }
        assertNotNull(httpRequest);
        assertEquals(httpRequest.getMethod(), HttpMethod.GET);
        assertEquals(httpRequest.getRequestTarget(), "/" );
        assertEquals(httpRequest.getOriginalHttpVersion(), "HTTP/1.1");
        assertEquals(httpRequest.getBestCompatibleVersion(), HttpVersion.HTTP_1_1);
    }

    @Test
    void parseBadHttpRequest()  {
        HttpRequest httpRequest = null;
        try {
            httpRequest = httpParser.parseHttpRequest(generateBadTestCase());
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCode.SERVER_ERROR_501_NOT_IMPLEMENTED);
        }
    }

    @Test
    void parseBadHttpRequestLongerName()  {
        HttpRequest httpRequest = null;
        try {
            httpRequest = httpParser.parseHttpRequest(generateBadTestCase2());
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCode.SERVER_ERROR_501_NOT_IMPLEMENTED);
        }
    }

    @Test
    void parseBadHttpRequestInvalidNoItems()  {
        try {
            HttpRequest httpRequest = httpParser.parseHttpRequest(generateBadTestCaseInvalidNoItems());
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCode.CLIENT_ERROR_400_BAD_REQUEST);
        }
    }

    @Test
    void parseBadHttpRequestEmptyReqLine()  {
        try {
            HttpRequest httpRequest = httpParser.parseHttpRequest(generateBadTestCaseEmptyReqLine());
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCode.CLIENT_ERROR_400_BAD_REQUEST);
        }
    }

    @Test
    void parseBadHttpRequestOnlyCRNoLine()  {
        try {
            HttpRequest httpRequest = httpParser.parseHttpRequest(generateBadTestCaseOnlyCRNoLine());
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCode.CLIENT_ERROR_400_BAD_REQUEST);
        }
    }

    @Test
    void parseBadHttpRequestWrongVersion()  {
        try {
            HttpRequest httpRequest = httpParser.parseHttpRequest(generateBadTestCaseWrongVersion());
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCode.CLIENT_ERROR_400_BAD_REQUEST);
        }
    }

    @Test
    void parseBadHttpRequestUnsupportedVersion()  {
        try {
            HttpRequest httpRequest = httpParser.parseHttpRequest(generateBadTestCaseUnsupportedVersion());
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCode.SERVER_ERROR_505_HTTP_VERSION_NOT_SUPPORTED);
        }
    }

    @Test
    void parseBadHttpRequestSupportedVersion()  {
        try {
            HttpRequest httpRequest = httpParser.parseHttpRequest(generateBadTestCaseSupportedVersion());
            assertNotNull(httpRequest);
            assertEquals(httpRequest.getBestCompatibleVersion(), HttpVersion.HTTP_1_1);
            assertEquals(httpRequest.getOriginalHttpVersion(), "HTTP/1.2");
        } catch (HttpParsingException e) {
            fail();
        }
    }




    private InputStream generateValidGETTestCase() {
        String rawData = "GET / HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Connection: keep-alive\r\n" +
                "Cache-Control: max-age=0\r\n" +
                "sec-ch-ua: \"Chromium\";v=\"112\", \"Google Chrome\";v=\"112\", \"Not:A-Brand\";v=\"99\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCase() {
        String rawData = "GeT / HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCase2() {
        String rawData = "GETTTT / HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCaseInvalidNoItems() {
        String rawData = "GET / AAAAAA HTTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCaseEmptyReqLine() {
        String rawData = "\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCaseOnlyCRNoLine() {
        String rawData = "GET / HTTP/1.1\r" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCaseWrongVersion() {
        String rawData = "GET / HTP/1.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCaseUnsupportedVersion() {
        String rawData = "GET / HTTP/2.1\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

    private InputStream generateBadTestCaseSupportedVersion() {
        String rawData = "GET / HTTP/1.2\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9,de-DE;q=0.8,de;q=0.7,hr;q=0.6\r\n"+
                "\r\n";

        InputStream inputStream= new ByteArrayInputStream(rawData.getBytes(StandardCharsets.US_ASCII)) {
        };
        return inputStream;
    }

}