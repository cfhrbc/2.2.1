package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {



    User add(User user);

    User findByCar(String model, int series);

    List<User> listUsers();
}