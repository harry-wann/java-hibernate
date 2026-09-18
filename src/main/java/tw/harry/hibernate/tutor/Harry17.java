package tw.harry.hibernate.tutor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.dao.AccountDao;
import tw.harry.hibernate.entity.Account;
import tw.harry.hibernate.entity.AccountInfo;
import tw.harry.hibernate.util.HibernateUtil;

public class Harry17 {
	
	public static void main(String[] args) {
		
		EntityTransaction transaction = null;

		try (
			EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("harry");
			EntityManager em = emf.createEntityManager()
		) {
	
			transaction = em.getTransaction();
			transaction.begin();
			
			Account account = em.find(Account.class, 15);
			AccountInfo info = account.getAccountinfo();
			
			em.remove(account);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

}
