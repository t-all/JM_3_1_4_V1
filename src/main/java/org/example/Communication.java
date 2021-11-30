package org.example;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Communication {

    private RestTemplate restTemplate;
    private HttpHeaders headers;
    private String URL = "http://91.241.64.178:7081/api/users";

    @Autowired
    public Communication(RestTemplate restTemplate, HttpHeaders headers) {
        this.restTemplate = restTemplate;
        this.headers = headers;
        this.headers.set("Cookie", String.join(";", restTemplate.headForHeaders(URL).get("Set-Cookie")));
    }

    public String saveUser() {
        System.out.println(headers);
        User user = new User(3L, "James", "Brown", (byte) 34);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
    }

    public String updateUser() {
        System.out.println(headers);
        User user = new User(3L, "Thomas", "Shelby", (byte) 34);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class, 3L).getBody();
    }

    public String deleteUser() {
        System.out.println(headers);
        HttpEntity<User> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(URL + "/" + 3L, HttpMethod.DELETE, entity, String.class).getBody();
    }

    public String getAnswer() {
        return saveUser() + updateUser() + deleteUser();
    }

}
