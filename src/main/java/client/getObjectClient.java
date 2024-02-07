package client;

import entity.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class getObjectClient {

    public static void main(String[] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        try{
            txn.begin();
            Message msg = (Message)session.get(Message.class, 2);
            System.out.println(msg);
        }
        catch (Exception e){
            if(txn != null){
                txn.rollback();
                e.printStackTrace();
            }
        }
        finally {
            if(session != null){
                session.close();
            }
        }
    }

}
