package domain;

public class Entreprise extends Contact {
	
	private String NumSiret;

	public Entreprise (){};
	
	public Entreprise (String siret, String firstName, String lastName, String email){
		//super(firstName,lastName,email);
		super();
		this.NumSiret=siret;
		
	};
	

	public void setNumSiret(String numSiret) {
		NumSiret = numSiret;
	}

	public String getNumSiret() {
		return NumSiret;
	}
	


}
