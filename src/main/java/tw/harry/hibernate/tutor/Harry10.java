package tw.harry.hibernate.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.dao.AccountDao;
import tw.harry.hibernate.entity.Account;
import tw.harry.hibernate.util.HibernateUtil;

public class Harry10 {

	public static void main(String[] args) {
		try (
			Session session = HibernateUtil.getSessionFactory().openSession()
		) {

		    String sql = """
		    	SELECT * FROM account
    		""";
		    
		    NativeQuery<Account> query = session.createNativeQuery(sql, Account.class);
		    List<Account> list = query.getResultList();
		    System.out.println(list.size());
		    
		    for (Account account : list) {
		    	System.out.printf("%s:%s:%s:%s:%s\n",
	    			account.getId(),
	    			account.getName(),
	    			account.getEmail(),
	    			account.getBirthday(),
	    			account.isEnable()
    			);
		    }
		}
	}

}
