package be.sgerard.test.spring6;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.Map;

@RestController
public class DemoController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/rest-client")
    public String restClient() {
        var url = "https://opentdb.com/api.php?amount={amount}&category={category}";

        final ResponseEntity<Map<String, Object>> entity = RestClient.create()
                .get()
                .uri(url, 1, 18)
                .retrieve()
                .onStatus(
                        HttpStatusCode::is4xxClientError,
                        (request, response) -> {
                            throw new IllegalArgumentException("Why you didn't do it properly?");
                        }
                )
                .onStatus(
                        HttpStatusCode::is5xxServerError,
                        (request, response) -> {
                            throw new IllegalArgumentException("They failed!");
                        }
                )
                .toEntity(new ParameterizedTypeReference<>() {
                });

        return entity.getBody() + "\n" + entity.getStatusCode() + "\n" + entity.getHeaders();
    }
}
