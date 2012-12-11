package domain;

public class Address {
	private long id;
	private String Street;
	private String City;
	private String zip;
	private String Country;

	public Address() {

	
	}

/*	public Address(String street, String city, String zip, String country) {
		super();
		Street = street;
		City = city;
		this.zip = zip;
		Country = country;
	}*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

}
