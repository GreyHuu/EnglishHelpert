package dao;

import entity.ReadingChooseEntity;
import entity.ReadingQuestionEntity;
import entity.ReadingTotalEntity;
import entity.ReadingtestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository("readingDao")
public class ReadingDaoImpl implements ReadingDao {

    @Resource
    private SessionFactory sessionFactory;


    private Session openSessionByFactory(SessionFactory sessionFactory) {
        return sessionFactory.openSession();
    }


    /**
     * @return 返回文章
     */
    @Override
    public List<ReadingtestEntity> getReading() {
        Session session = openSessionByFactory(sessionFactory);
        String hql = "from ReadingtestEntity";
        Query<ReadingtestEntity> query = session.createQuery(hql);
        return query.getResultList();
    }


    /**
     * @return 返回问题
     */
    @Override
    public List<ReadingQuestionEntity> getReadingQuestion() {
        Session session = openSessionByFactory(sessionFactory);
        String hql = "from ReadingQuestionEntity";
        Query<ReadingQuestionEntity> query = session.createQuery(hql);
        return query.getResultList();
    }


    /**
     * @param id 文章id
     * @return 返回单个文章的内容
     */
    @Override
    public ReadingtestEntity getReadingById(int id) {
        Session session = openSessionByFactory(sessionFactory);
        String hql = "from ReadingtestEntity where id =:getId";
        Query<ReadingtestEntity> query = session.createQuery(hql);
        query.setParameter("getId", id);
        List<ReadingtestEntity> list = query.getResultList();
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    /**
     * @param id 选项的id
     * @return 返回问题的选项
     */
    @Override
    public ReadingChooseEntity getReadingChooseById(int id) {
        Session session = openSessionByFactory(sessionFactory);
        String hql = "from ReadingChooseEntity where id =:getId";
        Query<ReadingChooseEntity> query = session.createQuery(hql);
        query.setParameter("getId", id);
        List<ReadingChooseEntity> list = query.getResultList();
        if (list.isEmpty())
            return null;
        return list.get(0);
    }

    /**
     * @param id 文章id
     * @return 返回该文章对应的所有问题
     */
    @Override
    public List<ReadingQuestionEntity> getReadingQuestionByTestId(int id) {
        Session session = openSessionByFactory(sessionFactory);
        String hql = "from ReadingQuestionEntity where readingId =:getId";
        Query<ReadingQuestionEntity> query = session.createQuery(hql);
        query.setParameter("getId", id);
        return query.getResultList();
    }

    @Override
    public String insertTotal(ReadingTotalEntity readingTotalEntity) {
        Session session = openSessionByFactory(sessionFactory);
        session.save(readingTotalEntity);
        return "true";
    }
}
