package domain;

import java.util.Set;

public interface IDAOContactGroup {

	public void addContactGroup(ContactGroup cgroup);
	
	public int deleteContactGroup(String groupName) ;	
	
	public Set<Contact> getContacts(String groupName);
	public ContactGroup getContactGroup(long group) ;
	
	public ContactGroup getContactGroup(String group) ;


}
