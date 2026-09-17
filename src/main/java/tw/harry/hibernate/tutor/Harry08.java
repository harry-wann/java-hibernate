package tw.harry.hibernate.tutor;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.entity.Account;
import tw.harry.hibernate.util.HibernateUtil;

public class Harry08 {

	public static void main(String[] args) {
		try (
			Session session = HibernateUtil.getSessionFactory().openSession()
		) {
		    Transaction ts = session.beginTransaction();
		    
		    String sql = """
		    	INSERT INTO cust
		    	(cname, tel, birthday)
		    	VALUES
		    	(:cname, :tel, :birth)
    		""";
		    
		    NativeQuery query = session.createNativeQuery(sql);
		    query.setParameter("cname", "John");
		    query.setParameter("tel", "945");
		    query.setParameter("birth", "1999-01-02");
		    query.executeUpdate();
			
			ts.commit();
		}
	}

}
