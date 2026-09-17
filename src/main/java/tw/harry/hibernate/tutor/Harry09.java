package tw.harry.hibernate.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.entity.Account;
import tw.harry.hibernate.util.HibernateUtil;

public class Harry09 {

	public static void main(String[] args) {
		try (
			Session session = HibernateUtil.getSessionFactory().openSession()
		) {

		    String sql = """
		    	SELECT * FROM account
    		""";
		    
		    NativeQuery query = session.createNativeQuery(sql);
		    List list = query.getResultList();
		    System.out.println(list.size());
		    
		    for (Object obj : list) {
		    	Object[] row = (Object[]) obj;
		    	System.out.printf("%s:%s:%s:%s:%s\n",
	    			row[0],
	    			row[1],
	    			row[2],
	    			row[3],
	    			row[4]
    			);
		    }
		}
	}

}
