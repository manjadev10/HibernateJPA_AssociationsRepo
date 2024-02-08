package OneToMany.OneToManyClient;

import OneToMany.OneToManyEntity.Guide;
import OneToMany.OneToManyEntity.Student;
import OneToMany.OneToManyUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToManyClient {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try {
            txn.begin();
            Guide guide = new Guide("2000MO10789", "Mike Lawson", 1000);
            //Guide guide = (Guide)session.get(Guide.class,1L);
            Student student = new Student("2014JT50123", "John Smith", guide);
            session.persist(student);
            txn.commit();
        } catch (Exception e) {
            if (txn != null) {
                txn.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
