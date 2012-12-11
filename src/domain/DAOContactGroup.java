package domain;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

public class DAOContactGroup implements IDAOContactGroup {

	public void addContactGroup(ContactGroup cgroup) {
		String hql = null;
		int size;
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			tx.begin();
			hql = "FROM ContactGroup as cgroup where cgroup.groupname like '" + cgroup.getGroupName()
					+ "'";

			Query query = session.createQuery(hql);
			List rec = query.list();
			size = rec.size();

			if (size > 0) {
				System.out.println("Le groupe existe deja!");
			} else {
				session.save(cgroup);
			}
			
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// session.close();
		
	}

	public int deleteContactGroup(String groupName) {
		ContactGroup cgroup = null;
		String hql = null;
		String hqlcontacts = null;
		String hqlgroup = null;
		int success = 0; // Connection con = null;
		int sizegroup, sizecontacts;
		try {
			System.out.println("delete group\n");

			hql = "FROM ContactGroup as cgroup where cgroup.groupname like '" + groupName
					+ "'";

			// if (c.getId() >= 0) {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			List rec = query.list();
			sizegroup = rec.size();

			if (sizegroup > 0) {
				cgroup = (ContactGroup) rec.get(0);
				System.out.println(cgroup.getGroupName() + "  \n");
				hqlcontacts = "From contacts where GROUP_ID=" + cgroup.getGroupId();
				Query requete = session.createQuery(hqlcontacts);
				List list = requete.list();
				sizecontacts = list.size();
				if(sizecontacts > 0) {
					System.out.println("Le groupe n'a pas pu etre supprimé, supprimez les contacts restant dans"+
							cgroup.getGroupName()+"\n");
				} else {
					hqlgroup = "delete FROM ContactGroup where GROUP_ID="
							+ cgroup.getGroupId();

					Query query2 = session.createQuery(hqlgroup);
					int row2 = query2.executeUpdate();
					if (row2 == 0) {
						System.out.println("Rien supprimé!\n");
					}
				}
				
			} else {
				System.out.println("Le groupe a ete supprimé!\n");

			}

			session.delete(cgroup);
			tx.commit();
			success = 1;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

	public Set<Contact> getContacts(String groupName) {
		ContactGroup cgroup = null;
		String hql = null;
		String hqlcontacts = null;
		String hqlgroup = null;
		int success = 0; // Connection con = null;
		int sizegroup, sizecontacts;
		Set<Contact> contacts = null;
		
		try {
			System.out.println("find contacts from group\n");

			hql = "FROM ContactGroup as cgroup where cgroup.groupname like '" + groupName
					+ "'";

			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			tx.begin();
			
			Query query = session.createQuery(hql);
			List rec = query.list();
			sizegroup = rec.size();

			if (sizegroup > 0) {
				cgroup = (ContactGroup) rec.get(0);
				System.out.println(cgroup.getGroupName() + "  \n");
				hqlcontacts = "From contacts where GROUP_ID=" + cgroup.getGroupId();
				Query requete = session.createQuery(hqlcontacts);
				List list = requete.list();
				sizecontacts = list.size();
				if(sizecontacts > 0) {
					System.out.println("Le groupe n'a pas de contacts\n");
				} else {
					for(int i = 0; i < list.size(); i++){
						contacts.add((Contact) list.get(i));
					}					
				}				
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}
	
	public ContactGroup getContactGroup(String group) {
		String hql = null;
		int size;
		ContactGroup cgroup = null;
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			tx.begin();
			hql = "FROM ContactGroup as cgroup where cgroup.groupName like '" + group
					+ "'";

			Query query = session.createQuery(hql);
			List rec = query.list();
			size = rec.size();

			if (size < 0) {
				System.out.println("Le groupe n'existe pas!");
			} else {
				cgroup = (ContactGroup) rec.get(0);
			}
			
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// session.close();
		return cgroup;
	}
	

	public ContactGroup getContactGroup(long group) {
		String hql = null;
		int size;
		ContactGroup cgroup = null;
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			tx.begin();
			hql = "FROM ContactGroup as cgroup where cgroup.id =" + group
					+ "'";

			Query query = session.createQuery(hql);
			List rec = query.list();
			size = rec.size();

			if (size < 0) {
				System.out.println("Le groupe n'existe pas!");
			} else {
				cgroup = (ContactGroup) rec.get(0);
			}
			
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// session.close();
		return cgroup;
	}


}
