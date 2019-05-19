package mate.academy.database.good;

import mate.academy.model.Code;
import mate.academy.util.HibernateSessionFactoryUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Optional;

public class PurchaseCodeDaoHib implements PurchaseCodeDao {
    private static final Logger logger = Logger.getLogger(PurchaseCodeDaoHib.class);

    @Override
    public int addCode(Code code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(code);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public int removeCode(Code code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(code);
        transaction.commit();
        session.close();
        return 1;
    }

    @Override
    public Optional<Code> getCode(String value) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Code WHERE value = :value");
        query.setParameter("value", value);
        Code code = (Code) query.uniqueResult();
        session.close();
        return Optional.ofNullable(code);
    }

    @Override
    public Optional<Code> getCode(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Code code = session.get(Code.class, id);
        session.close();
        return Optional.ofNullable(code);
    }

    @Override
    public List<Code> getCodes() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Code> codes = session.createQuery("From Code").list();
        return codes;
    }
}
