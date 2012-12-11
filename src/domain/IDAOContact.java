package domain;

import java.util.ArrayList;
import java.util.Set;

public interface IDAOContact {
	
	//public Contact addContact(long idContact, String firstname, String lastname, String email);
	public Contact addContact(Contact contact, Address address,
			Set<PhoneNumber> phones, Set<ContactGroup> cgroup);
	
	public int deleteContact(String firtName,String lastName) ;	
	
	public Contact getContact(long id);
	public Contact getContact(String firstName,String lastName);

	public Contact modifyContact(long id,Contact contact, Address address,
			Set<PhoneNumber> phones, Set<ContactGroup> cgroup);
	
	public ArrayList<Contact> getContactByFirstName(String firstname);
	
	public ArrayList<Contact> getContactByLastName(String lastname);
	
	public ArrayList<Contact> getContactByEmail(String email);
	
}
