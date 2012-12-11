package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class DAOContact implements IDAOContact {

	/**
	 * Rajoute un contact dans la base de donnees.
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return renvoit le nouveau contact
	 */

	public Contact addContact(Contact contact, Address address,
			Set<PhoneNumber> phones, Set<ContactGroup> cgroup) {
		try {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			tx.begin();
			// Ajuste l'adresse
			contact.setAdd(address);
			for (PhoneNumber p : phones) {
				p.setContacts(contact);
				contact.getPhones().add(p);
			}
			ContactGroup cgg = null;
			List<ContactGroup> cg1;
			for (ContactGroup cg : cgroup) {
				cg1 = session.createQuery(
						"From ContactGroup as cg where cg.id="
								+ cg.getGroupId()).list();
				System.out.println("group id :" + cg.getGroupId());
				/*
				 * cg1 = session.createQuery( "From ContactGroup").list();
				 */
				System.out.println("cg1 size" + cg1.size());
				cgg = (ContactGroup) cg1.get(0);
				System.out.println("groupe " + cgg.getGroupName());
				// contact.getBooks().add(cgg);
				// cgg.getContacts().add(contact);
				// session.save(cgg);
			}

			contact.getBooks().add(cgg);
			cgg.getContacts().add(contact);
			session.save(cgg);
			session.save(contact);
			//session.save(address);
			for (PhoneNumber cg : phones) {
				session.save(cg);
			}
			/*
			 * for (ContactGroup cg : cgroup) { session.save(cg); }
			 */
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// session.close();
		return contact;
	}

	/**
	 * Suppression d'un contact a partir de son identifiant
	 * 
	 * @param id
	 * @return vrai si la suppression a bien ete effectuee
	 */
	public Contact getContact(String firstName, String lastName) {
		Contact c = null;
		String hql = null;

		try {
			hql = "FROM Contact as c where c.firstName like '" + firstName
					+ "'" + " and c.lastName like '" + lastName + "'";
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			List rec = query.list();
			int size = rec.size();
			if (size > 0) {
				c = (Contact) rec.get(0);
			} else {
				System.out.println("le contact n'existe pas");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;

	}

	public int deleteContact(String firstName, String lastName) {
		Contact c = null;

		String hql = null;
		String hqlphone = null;
		String hqlgroup = null;
		int success = 0; // Connection con = null;
		try {
			System.out.println("delete\n");

			hql = "FROM Contact as c where c.firstName like '" + firstName
					+ "'" + " and c.lastName like '" + lastName + "'";

			// if (c.getId() >= 0) {
			Session session = HibernateUtil.getSessionFactory()
					.getCurrentSession();
			org.hibernate.Transaction tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			List rec = query.list();
			int size = rec.size();

			if (size > 0) {
				c = (Contact) rec.get(0);
				Address a = c.getAdd();
				System.out.println(c.getFirstName() + " " + c.getLastName()
						+ " " + a.getStreet() + "  \n");
				hqlphone = "delete FROM PhoneNumber where CONTACT_ID="
						+ c.getId();
				query = session.createQuery(hqlphone);
			//session.createQuery("delete FROM Address where ADDRESS_ID="+a.getId()).executeUpdate();
			

				List recContactg = session.createQuery("FROM ContactGroup ").list();
				for(int i=0;i<recContactg.size();i++){
					ContactGroup contactg=(ContactGroup)recContactg.get(i);
				
						
						if (contactg.getContacts().contains(c)) {
							contactg.getContacts().remove(c);
							c.getBooks().remove(contactg);
							//session.delete(c);
							//session.createQuery("DELETE FROM contacts where CONTACT_ID="+c.getId());
							session.update(contactg);
						}
				}
				
			/*	Query query2 = session.createQuery(hqlgroup);
				*/int row = query.executeUpdate();
				/*int row2 = query2.executeUpdate();
				if ((row == 0) && (row2 == 0)) {
					System.out.println("rien supprimŽ\n");

				} else {
					System.out.println("les elements ont ete supprimŽes \n");

				}*/
				//session.delete(a);
				session.delete(c);
				tx.commit();
				success = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}

	/**
	 * Recuperation d'un contact a partir de son identifiant
	 * 
	 * @param id
	 * @return
	 */
	public Contact getContact(long id) {
		List rec = null;
		Contact contact = new Contact();
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			tx.begin();
			String hql = "FROM Contact where CONTACT_ID=" + id;
			Query query = session.createQuery(hql);
			rec = query.list();
			int size = rec.size();

			if (size > 0) {
				contact.setId(((Contact) rec.get(0)).getId());
				contact.setFirstName(((Contact) rec.get(0)).getFirstName());
				contact.setLastName(((Contact) rec.get(0)).getLastName());
				contact.setEmail(((Contact) rec.get(0)).getEmail());
				contact.setAdd(((Contact) rec.get(0)).getAdd());
				tx.commit();

			}
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out
		// .println(contact.getLastName() + " " + contact.getFirstName());

		return contact;
	}

	/**
	 * Methode qui modifie les coordonees d'un contact
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!A FAIRE
	 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 * 
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @return
	 */

	public Contact modifyContact(long id, Contact c, Address address,
			Set<PhoneNumber> phones, Set<ContactGroup> cgroup) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		tx.begin();
		Contact contact = null;
		try {
			contact = (Contact) session.get(Contact.class, id);
			if (c.getFirstName() != "")
				contact.setFirstName(c.getFirstName());
			if (c.getLastName() != "")
				contact.setLastName(c.getLastName());
			if (c.getEmail() != "")
				contact.setEmail(c.getEmail());

			if (address.getStreet() != "")

				contact.getAdd().setStreet(address.getStreet());
			if (address.getCity() != "")
				contact.getAdd().setCity(address.getCity());
			if (address.getZip() != "")
				contact.getAdd().setZip(address.getZip());
			if (address.getCountry() != "")
				contact.getAdd().setCountry(address.getCountry());
			Set<ContactGroup> oldbooks = contact.getBooks();
			if (cgroup.size() != 0) {
				for (ContactGroup old : oldbooks) {
					ContactGroup contactg = (ContactGroup) session.get(
							ContactGroup.class, old.getGroupId());
					if (contactg.getContacts().contains(contact)) {
						contactg.getContacts().remove(contact);
						session.update(contactg);
					}
				}

				contact.setBooks(cgroup);
				for (ContactGroup cg : cgroup) {
					ContactGroup contactg = (ContactGroup) session.get(
							ContactGroup.class, cg.getGroupId());
					if (!contactg.getContacts().contains(contact)) {

						contactg.getContacts().add(contact);
						session.update(contactg);
					}

				}

			}
			// HashSet<ContactGroup> groups = new HashSet<ContactGroup>();
			HashSet<PhoneNumber> ph = new HashSet<PhoneNumber>();

			// groups.add((ContactGroup) cgroup);
			// contact.setBooks(groups);
			String hql = "From PhoneNumber where CONTACT_ID=" + contact.getId();
			Query requete = session.createQuery(hql);
			List list = requete.list();
			int i = 0;
			System.out.println(list.size());
			/*
			 * for (i=0; i < list.size(); i++){ PhoneNumber
			 * num1=(PhoneNumber)list.get(i); num1.setPhoneKind(phones.);
			 * num1.setPhoneNumber(phoneNumber); }
			 */

			for (PhoneNumber p : phones) {
				PhoneNumber num1 = (PhoneNumber) list.get(i);
				num1.setPhoneKind(p.getPhoneKind());
				num1.setPhoneNumber(p.getPhoneNumber());
				System.out.println(p.getPhoneNumber());
				session.update(num1);
				i++;
			}

			contact.setPhones(ph);
			session.update(contact);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();

		return contact;
	}

	public ArrayList<Contact> getContactByFirstName(String firstname) {

		ArrayList<Contact> contacts = new ArrayList<Contact>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String request = " FROM Contact as c  WHERE c.firstName like '"
					+ firstname + "'";
			Query requete = session.createQuery(request);
			ArrayList List = (ArrayList) requete.list();
			int i;
			System.out.println(List.size());
			for (i = 0; i < List.size(); i++) {
				contacts.add((Contact) List.get(i));

				contacts.get(i).setId(((Contact) List.get(i)).getId());
				contacts.get(i).setFirstName(
						((Contact) List.get(i)).getFirstName());
				contacts.get(i).setLastName(
						((Contact) List.get(i)).getLastName());
				contacts.get(i).setEmail(((Contact) List.get(i)).getEmail());
				contacts.get(i).setAdd(((Contact) List.get(i)).getAdd());

				System.out.println("contact trouvŽ "
						+ contacts.get(i).getFirstName() + " "
						+ contacts.get(i).getLastName() + " "
						+ contacts.get(i).getEmail() + " "
						+ contacts.get(i).getAdd().getCity());

			}
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/**
	 * Renvoit la liste des contacts correspondant au nom lastname
	 * 
	 * @param lastname
	 * @return
	 */
	public ArrayList<Contact> getContactByLastName(String lastname) {

		ArrayList<Contact> contacts = new ArrayList<Contact>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		/*
		 * ResultSet rec = null; Connection con = null;
		 */
		try {
			String request = " FROM Contact as c  WHERE c.lastName like '"
					+ lastname + "'";
			Query requete = session.createQuery(request);
			List list = requete.list();
			int i;
			System.out.println(list.size());

			for (i = 0; i < list.size(); i++) {
				contacts.add((Contact) list.get(i));

				contacts.get(i).setId(((Contact) list.get(i)).getId());
				contacts.get(i).setFirstName(
						((Contact) list.get(i)).getFirstName());
				contacts.get(i).setLastName(
						((Contact) list.get(i)).getLastName());
				contacts.get(i).setEmail(((Contact) list.get(i)).getEmail());
				contacts.get(i).setAdd(((Contact) list.get(i)).getAdd());

				System.out.println("contact trouvŽ "
						+ contacts.get(i).getFirstName() + " "
						+ contacts.get(i).getLastName() + " "
						+ contacts.get(i).getEmail() + " "
						+ contacts.get(i).getAdd().getCity());

			}
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

	/**
	 * Renvoit la liste des contacts correspondant a l'email email
	 * 
	 * @param email
	 * @return
	 */
	public ArrayList<Contact> getContactByEmail(String email) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction tx = session.beginTransaction();

		try {
			String request = " FROM Contact as c  WHERE c.email like '" + email
					+ "'";
			Query requete = session.createQuery(request);
			List list = requete.list();
			int i;
			System.out.println(list.size());

			for (i = 0; i < list.size(); i++) {
				contacts.add((Contact) list.get(i));

				contacts.get(i).setId(((Contact) list.get(i)).getId());
				contacts.get(i).setFirstName(
						((Contact) list.get(i)).getFirstName());
				contacts.get(i).setLastName(
						((Contact) list.get(i)).getLastName());
				contacts.get(i).setEmail(((Contact) list.get(i)).getEmail());
				contacts.get(i).setAdd(((Contact) list.get(i)).getAdd());

				System.out.println("contact trouvŽ "
						+ contacts.get(i).getFirstName() + " "
						+ contacts.get(i).getLastName() + " "
						+ contacts.get(i).getEmail() + " "
						+ contacts.get(i).getAdd().getCity());

			}
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return contacts;
	}

}
