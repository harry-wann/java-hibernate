package tw.harry.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import tw.harry.hibernate.entity.Account;
import tw.harry.hibernate.util.HibernateUtil;

public class AccountDao {
	
	public void addAccount(Account account) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			ts = session.beginTransaction();
			session.persist(account);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}
	
	public void delAccount(Account account) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			ts = session.beginTransaction();
			session.remove(account);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}
	
	public void updateAccount(Account account) {
		Transaction ts = null;
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			ts = session.beginTransaction();
			session.merge(account);
			ts.commit();
		} catch (Exception e) {
			if (ts != null) {
				ts.rollback();
			} else {
				
			}
		}
	}
	
	public Account findById(int id) {
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			return session.find(Account.class, id);
		}
	}
	
	public List<Account> findByEmail(String email) {
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			String hql = "FROM Account WHERE email LIKE :email";
			
			Query<Account> query = session.createQuery(hql, Account.class);
			
			query.setParameter("email", "%" + email + "%");
			
			return query.getResultList();
		}
	}
	
	public List<Account> findAll() {
		try (
			Session session = HibernateUtil.getSessionFactory().openSession();
		) {
			String hql = "FROM Account";
			Query<Account> query = session.createQuery(hql, Account.class);
			return query.getResultList();
		}
	}
}
