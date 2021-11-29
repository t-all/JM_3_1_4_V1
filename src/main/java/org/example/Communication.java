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

//    public List<User> getAllUsers() {
//        ResponseEntity<List<User>> responseEntity =
//                restTemplate.exchange(URL, HttpMethod.GET, null,
//                        new ParameterizedTypeReference<List<User>>() {
//                        });
//
//        List<User> allUser = responseEntity.getBody();
//        //cookie
//        RestTemplate template = new RestTemplate();
//        ResponseEntity<String> forEntity = template.getForEntity(URL, String.class);
//        forEntity.getHeaders().get("Set-Cookie").stream().forEach(System.out::println);
//        headers.set("Cookie", String.join(";", restTemplate.headForHeaders(URL).get("Set-Cookie")));
//        return allUser;
//    }

//    public User getUser(Long id) {
//      User user = restTemplate.getForObject(URL + "/" + id, User.class);
//
//        headers.set("Cookie", String.join(";", restTemplate.headForHeaders(URL).get("Set-Cookie")));
//
//        return user;
//    }

    public String saveUser() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Cookie", String.join(";", restTemplate.headForHeaders(URL).get("Set-Cookie")));
        System.out.println(headers);
        User user = new User(3L, "James", "Brown", (byte) 34);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);

        return restTemplate.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
    }

//    public ResponseEntity<String> editUser(User user) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Cookie", String.join(";", restTemplate.headForHeaders(URL).get("Set-Cookie")));
//
//        HttpEntity<User> entity = new HttpEntity<>(user, headers);
//
//        return restTemplate.exchange(URL+ "/" + user.getId(), HttpMethod.PUT, entity, String.class);
//    }

    public String updateUser() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Cookie", String.join(";", restTemplate.headForHeaders(URL).get("Set-Cookie")));
        System.out.println(headers);
        User user = new User(3L, "Thomas", "Shelby", (byte)34);
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class, 3L).getBody();
    }

    public String deleteUser() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Cookie", String.join(";", restTemplate.headForHeaders(URL).get("Set-Cookie")));
        System.out.println(headers);
        HttpEntity<User> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(URL+ "/"+3L, HttpMethod.DELETE, entity, String.class).getBody();



    }

    public String all() {
       return saveUser() + updateUser() + deleteUser();
    }


}
