package org.example;

import org.example.config.Config;
import org.example.model.User;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigReactiveWebApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);

//        List<User> allUsers = communication.getAllUsers();
//        System.out.println(allUsers);

//        User user = new User(3L, "James", "Brown", (byte) 34);
//        ResponseEntity<String> saveUser = communication.saveUser(user);
//        System.out.println(saveUser.getBody());

//        User user1 = new User( 3L, "Thomas", "Shelby", (byte) 34);
////        user1.setId(3L);
//        ResponseEntity<String> editUser = communication.editUser(user1);
//        ResponseEntity<String> up = communication.updateUser();
//        System.out.println(up.getBody());
//
//        ResponseEntity<String> deleteUser = communication.deleteUser(3L);
//        System.out.println(deleteUser.getBody());
        System.out.println(communication.all());


    }
}
