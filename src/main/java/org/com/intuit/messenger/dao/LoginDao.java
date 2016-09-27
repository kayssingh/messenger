package org.com.intuit.messenger.dao;

import java.util.List;

import org.com.intuit.messenger.util.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;

public class LoginDao {
	
	public static boolean validate(String name,String pass){  
		boolean status=false;  
		try{  
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.setFlushMode(FlushMode.MANUAL);
		    ManagedSessionContext.bind(session);
		    
	        Query query = session.createQuery("from User where userName = '" + name + "' and password = '" + pass +"'");
	        
	        List result = (List) query.list();
		    
	        if(result != null)
	        	status = true;        
		}catch(Exception e){
			System.out.println(e);
		}  		
		return status;  
	}  

}
