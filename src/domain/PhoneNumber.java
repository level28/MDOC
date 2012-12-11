package domain;

public class PhoneNumber {

	
	/**
	 * @param args
	 */

		private long id;
		private String phoneKind;
		private String phoneNumber;
		private Contact contacts;
		
		public PhoneNumber(){
			
			
			
		}
		
		
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String getPhoneKind() {
			return phoneKind;
		}
		public void setPhoneKind(String phoneKind) {
			this.phoneKind = phoneKind;
		}

		public Contact getContacts() {
			return contacts;
		}

		public void setContacts(Contact contacts) {
			this.contacts = contacts;
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}
		
		
		// TODO Auto-generated method stub

	

}
