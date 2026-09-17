package tw.harry.hibernate.tutor;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.entity.Account;

public class Harry06 {

	public static void main(String[] args) {
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("harry");
		EntityManager em = emf.createEntityManager();
		
		// JPQL, 從 Entity 視角出發
		Account account = em.createQuery("""
			SELECT a FROM Account a
			WHERE a.email = :email
		""", Account.class)
			.setParameter("email", "amy@harry.me")
			.getSingleResult();
		
		System.out.println(account.getName());
		
		em.close();
		emf.close();
	}

}
