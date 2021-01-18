package fr.afpa.gestion.inscription.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class CentreDTO.
 */
public class CentreDTO extends Dto{

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4212469255258101864L;

	
	/** The idcentre. */
	private Integer idcentre;

	/** The adresse. */
	@Size(max=300) //maximum 300 caractères
	private String adresse;

	/** The nom. */
	@NotNull @Size(max=50,min=1) //entre 1 et 50 caractères
	private String nom;

	/** The telephone. */
	@Size(max=10,min=10) @PositiveOrZero //ou null ou égal a 10
	private Integer telephone;

	

	
	
	/**
	 * Instantiates a new centre DTO.
	 */
	public CentreDTO() {
		super();
	}



	/**
	 * Instantiates a new centre DTO.
	 *
	 * @param idcentre the idcentre
	 * @param nom the nom
	 * 
	 * 
	 */
	
	public CentreDTO(Integer idcentre, @NotNull @Size(max = 50, min = 1) String nom) {
		super();
		this.idcentre = idcentre;
		this.nom = nom;
	}
	

	/**
	 * Instantiates a new centre DTO.
	 *
	 * 
	 * @param nom the nom
	 * 
	 * 
	 */
	
	
	
	public CentreDTO(String nom) {
		super();
		this.nom = nom;
	}

	

	



	/**
	 * Instantiates a new centre DTO.
	 *
	 * @param idcentre the idcentre
	 * @param adresse the adresse
	 * @param nom the nom
	 * @param telephone the telephone
	 */
	public CentreDTO(Integer idcentre, String adresse, String nom, Integer telephone) {
		super();
		this.idcentre = idcentre;
		this.adresse = adresse;
		this.nom = nom;
		this.telephone = telephone;
		
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Override
	public Integer getId() {
		return idcentre;
	}



	/**
	 * Gets the idcentre.
	 *
	 * @return the idcentre
	 */
	public Integer getIdcentre() {
		return idcentre;
	}



	/**
	 * Sets the idcentre.
	 *
	 * @param idcentre the new idcentre
	 */
	public void setIdcentre(Integer idcentre) {
		this.idcentre = idcentre;
	}



	/**
	 * Gets the adresse.
	 *
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}



	/**
	 * Sets the adresse.
	 *
	 * @param adresse the new adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * Gets the telephone.
	 *
	 * @return the telephone
	 */
	public Integer getTelephone() {
		return telephone;
	}



	/**
	 * Sets the telephone.
	 *
	 * @param telephone the new telephone
	 */
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}





	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "CentreDTO [idcentre=" + idcentre + ", adresse=" + adresse + ", nom=" + nom + ", telephone=" + telephone
				+ "]";
	}



	
	
	
}
