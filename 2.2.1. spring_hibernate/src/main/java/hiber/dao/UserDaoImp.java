package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public User userAndCar(int series, String model) {
        Query query = sessionFactory.getCurrentSession().createQuery("select user from User user where user.car.series = :series and user.car.model = :model")
                .setParameter("series", series)
                .setParameter("model", model);
        return (User) query.getSingleResult();
    }
}
