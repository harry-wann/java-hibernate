package tw.harry.hibernate.tutor;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tw.harry.hibernate.entity.Account;

public class Harry05 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("ID: ");
		int id = scanner.nextInt();
		System.out.println("Password: ");
		String password = scanner.next();
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("harry");
		EntityManager em = emf.createEntityManager();
		
		Account account = em.find(Account.class, id);
		
		if (BCrypt.checkpw(password, account.getPassword())) {
			System.out.printf("Welcome %s\n", account.getName());
		} else {
			System.out.println("Login failed");
		}
		
		em.close();
		emf.close();
	}

}
