package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    public User user;
    public User user1;
    public User user2;

    @BeforeEach
    void setUp() {
        user = new User("Иван", 12, Sex.FEMALE);
        user1 = new User("Аркадий 12 лет пошлый", 15, Sex.MALE);
        user2 = new User("Илюха одну букву поменяй на Ш", 19, Sex.MALE);
    }

    @Test
    void getAllUsers() {
        List<User> users = User.getAllUsers();

        List<User> users1 = new ArrayList<>();
        users1.add(user);
        users1.add(user1);
        users1.add(user2);

        assertEquals(users, users1);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = User.getAllUsers(Sex.MALE);

        List<User> users1 = new ArrayList<>();
        users1.add(user1);
        users1.add(user2);

        assertEquals(users, users1);
    }

    @Test
    void getHowManyUsers() {
        List<User> users = User.getAllUsers();

        List<User> users1 = new ArrayList<>();
        users1.add(user);
        users1.add(user1);
        users1.add(user2);

        assertEquals(users.size(), users1.size());
    }

    @Test
    void testGetHowManyUsers() {
        List<User> users = User.getAllUsers(Sex.FEMALE);

        List<User> users1 = new ArrayList<>();
        users1.add(user);

        assertEquals(users.size(), users1.size());
    }

    @Test
    void getAllAgeUsers() {
        int count = 0;
        int users = User.getAllAgeUsers();

        List<User> users1 = new ArrayList<>();
        users1.add(user);
        users1.add(user1);
        users1.add(user2);

        for(User user : users1){
            count += user.getAge(); 
        }

        assertEquals(users, count);
    }
 
    @Test
    void testGetAllAgeUsers() {
        int count = 0;
        int users = User.getAllAgeUsers(Sex.FEMALE);

        List<User> users1 = new ArrayList<>();
        users1.add(user);

        for(User user : users1){
            count += user.getAge();
        }

        assertEquals(users, count);
    }

    @Test
    void getAverageAgeOfAllUsers() {
        int count = 0;
        int users = (User.getAllAgeUsers() / User.getHowManyUsers());

        List<User> users1 = new ArrayList<>();
        users1.add(user);
        users1.add(user1);
        users1.add(user2);

        for(User user : users1){
            count += user.getAge();
        }

        assertEquals(users, count / User.getHowManyUsers());
    }

    @Test
    void testGetAverageAgeOfAllUsers() {
        int count = 0;
        int users = (User.getAllAgeUsers(Sex.MALE) / User.getHowManyUsers(Sex.MALE));

        List<User> users1 = new ArrayList<>();;
        users1.add(user1);
        users1.add(user2);

        for(User user : users1){
            count += user.getAge();
        }

        assertEquals(users, count / User.getHowManyUsers(Sex.MALE));
    }
}