package domain;

import java.util.HashSet;
import java.util.Set;



public class ContactGroup {
	private long groupId;
	private String groupName;
	//private Set<Contact> contacts = new Set();
	private Set <Contact> contacts=new HashSet<Contact>();
	
	public ContactGroup(){
		
		
	}
	
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set <Contact> getContacts() {
	
		return contacts;
	}

	public void setContacts(Set <Contact> contacts) {
		this.contacts = contacts;
	}
	



}
