package dao;

import entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<UserEntity> getAllUser() {

        Configuration cfg = new Configuration().configure();

        sessionFactory = cfg.buildSessionFactory();

        //当getCurrentSession所在的方法，或者调用该方法的方法绑定了事务之后，session就与当前线程绑定了，也就能通过currentSession来获取，否则就不能。
//        Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        //后面当使用JPA的时候，EntityManager 类似于 Session


        //       此处的应该写对象名称 而不是数据库名称
        String hql = "from UserEntity";
        Query<UserEntity> query = session.createQuery(hql);


        //将所有的数据查询出来并放到List集合里
        List<UserEntity> list = query.getResultList();

        //返回list集合
        return list;
    }
}
