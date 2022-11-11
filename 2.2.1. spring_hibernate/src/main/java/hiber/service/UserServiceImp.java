package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
//      return userDao.listUsers();
      List<User> userList = userDao.listUsers();
      userList.forEach(i -> System.out.printf(" ID: %s%n Name: %s%n LastName: %s%n email: %s%n CarModel: %s%n Series: %s%n%n",
              i.getId(), i.getFirstName(), i.getLastName(), i.getEmail(), i.getCar().getModel(), i.getCar().getSeries()));
      return userList;
   }

   @Transactional
   @Override
   public User userAndCar(int series, String model) {
      return userDao.userAndCar(series, model);
   }

}
