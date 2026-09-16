package tw.harry.hibernate.tutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.entity.Account;

public class Harry02 {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("harry");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("OK");
		
		em.getTransaction().begin();
		
		Account account = new Account();
		account.setName("John");
		account.setEmail("jonh@harry.me");
		
		em.persist(account);
		
		em.getTransaction().commit();

		em.close();
		emf.close();
	}

}
