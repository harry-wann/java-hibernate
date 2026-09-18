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
import tw.harry.hibernate.entity.Order;
import tw.harry.hibernate.service.OrderService;
import tw.harry.hibernate.service.OrderServiceImpl;
import tw.harry.hibernate.util.HibernateUtil;

public class Harry18 {
	
	public static void main(String[] args) {
		
		OrderService service = new OrderServiceImpl();
		service.delOrder(1L);
	}

}
