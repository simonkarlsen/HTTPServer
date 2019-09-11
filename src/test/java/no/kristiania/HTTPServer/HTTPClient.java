package no.kristiania.HTTPServer;

import no.kristiania.ClientHTTP;
import no.kristiania.HttpClientResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HTTPClient {

    @Test
    void mathShouldWork() {
        assertEquals(4, 2+2);
    }

    @Test
    void shouldReadStatusCode() throws IOException {
        ClientHTTP client = new ClientHTTP("urlecho.appspot.com", "/echo");
        HttpClientResponse response = client.executeRequest();
        assertEquals(200, response.getStatusCode());

    }
    @Test
    void should302StatusCode() throws IOException {
        ClientHTTP client = new ClientHTTP("urlecho.appspot.com", "/echo?status=302");
        HttpClientResponse response = client.executeRequest();
        assertEquals(302, response.getStatusCode());

    } //
    @Test
    void shouldFailureStatusCode() throws IOException {
        ClientHTTP client = new ClientHTTP("urlecho.appspot.com", "/echo?status=401");
        HttpClientResponse response = client.executeRequest();
        assertEquals(401, response.getStatusCode());

    }

}
