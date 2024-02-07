package client;

import org.hibernate.Session;

import util.HibernateUtil;
import entity.Message;

public class HelloWorldClient {
	public static void main(String[] args) {
				Session session = HibernateUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        
        		Message message = new Message( "we are in hell to make it heaven tests - logging 2SQL SATS" );
        
        		session.save(message);    
        
        		session.getTransaction().commit();
        		session.close();
	
	}
}

