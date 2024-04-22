package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        Car car1 = new Car("Camry", 123);
        Car car2 = new Car("M", 3);
        carService.addCar(car1);
        carService.addCar(car2);
        User user1 = new User("Stethem", "Jon", "user1@bk.ru");
        User user2 = new User("Stalone", "Selvester", "user2@bk.ru");


        user1.setCar(car1);
        user2.setCar(car2);
        userService.add(user1);
        userService.add(user2);



        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        User entity = userService.findByCar("Camry", 123);
        User entity1 = userService.findByCar("M", 3);
        System.out.println(entity.getLastName());
        System.out.println(entity1.getLastName());

        context.close();
    }
}
