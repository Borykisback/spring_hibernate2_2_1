package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user_one = (new User("User1", "Lastname1", "user1@mail.ru"));
        user_one.setCar(new Car( 215512, "supra"));
        userService.add(user_one);

        User user_two = (new User("User2", "Lastname2", "user2@mail.ru"));
        user_two.setCar(new Car( 137574, "nissan"));
        userService.add(user_two);

        User user_three = (new User("User3", "Lastname3", "user3@mail.ru"));
        user_three.setCar(new Car( 357524, "lada"));
        userService.add(user_three);

        userService.listUsers();

        System.out.println(userService.userAndCar( 137574, "nissan"));

        context.close();
    }
}
