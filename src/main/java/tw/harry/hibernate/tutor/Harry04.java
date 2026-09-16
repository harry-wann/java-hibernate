package tw.harry.hibernate.tutor;

import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.entity.Account;

public class Harry04 {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("harry");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Account account = new Account();
		account.setName("Vivian");
		account.setEmail("vivian@harry.me");
		account.setPassword(BCrypt.hashpw("12345678", BCrypt.gensalt()));
		account.setBirthday(LocalDate.of(1993, 11, 6));
		account.setEnable(true);
		
		em.persist(account);
		
		em.getTransaction().commit();
		
		System.out.printf("ID: %d\n", account.getId());
		
		em.close();
		emf.close();
	}

}
