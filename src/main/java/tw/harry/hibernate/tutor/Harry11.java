package tw.harry.hibernate.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.dao.AccountDao;
import tw.harry.hibernate.entity.Account;
import tw.harry.hibernate.util.HibernateUtil;

public class Harry11 {
	
	public static void main(String[] args) {

		AccountDao dao = new AccountDao();
		
		Account account = dao.findById(2);
		if (account != null) {
			System.out.println(account.getEmail());
			account.setName("New" + account.getName());
			dao.updateAccount(account);
		}
		
	}

}
