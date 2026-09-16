package tw.harry.hibernate.tutor;

import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.entity.Account;

public class Harry03 {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("harry");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("OK");
		
		Account account = em.find(Account.class, 6);
		
		System.out.printf("%d %s %s", account.getId(), account.getName(), account.getEmail());
		
//		Account account = new Account();
//		account.setId(3);
		
		em.getTransaction().begin();
		account.setBirthday(LocalDate.of(1997, 11, 6));
		account.setPassword(BCrypt.hashpw("12345678", BCrypt.gensalt()));
		em.getTransaction().commit();
		

		em.close();
		emf.close();
	}

}
