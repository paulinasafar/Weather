package server.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpConnectionWorkerThread extends Thread {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpConnectionWorkerThread.class);
    private Socket socket;

    public HttpConnectionWorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        String page = "<html><head><title>Simple Java HTTP Server</title></head><body><h1>This page was served using my Simple Java HTTP Server</h1></body></html>";
        InputStream inputStream = null;
        OutputStream outputStream = null;
        final String html = page;
        final String CRLF = "\n\r"; //13,10

        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            String response =
                    "HTTP/1.1 200 OK" + CRLF + //Status line of the response: HTTP VERSION_CODE RESPONSE_MESSAGE
                            "Content-Length: " + html.getBytes().length + CRLF +  //HEADER
                            CRLF +
                            html +
                            CRLF + CRLF;
            outputStream.write(response.getBytes());
            LOGGER.info(" * Connection processing finished. ");

        } catch (IOException e) {
            LOGGER.error("Problem with communication: ", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
