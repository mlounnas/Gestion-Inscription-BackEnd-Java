package fr.afpa.gestion.inscription.dto;

import java.time.LocalDate;

public class SessionDto extends Dto {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idsession;
	
	private String nom;
	
	private LocalDate datedebut;
	
	private LocalDate datefin;
	
	private LocalDate datedebutpae;
	
	private LocalDate datefinpae;
	
	private LocalDate datecertification;
	
	private String nomsessionaveccentre;
	
	private Integer idcentre;
	
	private Integer idformation;


	public SessionDto() {
		super();
	}

	public SessionDto(Integer idsession, String nom, LocalDate datedebut, LocalDate datefin, LocalDate datedebutpae,
			LocalDate datefinpae, LocalDate datecertification, String nomsessionaveccentre, Integer idcentre,
			Integer idformation) {
		super();
		this.idsession = idsession;
		this.nom = nom;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.datedebutpae = datedebutpae;
		this.datefinpae = datefinpae;
		this.datecertification = datecertification;
		this.nomsessionaveccentre = nomsessionaveccentre;
		this.idcentre = idcentre;
		this.idformation = idformation;
	}

	public Integer getIdsession() {
		return idsession;
	}

	public void setIdsession(Integer idsession) {
		this.idsession = idsession;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(LocalDate datedebut) {
		this.datedebut = datedebut;
	}

	public LocalDate getDatefin() {
		return datefin;
	}

	public void setDatefin(LocalDate datefin) {
		this.datefin = datefin;
	}

	public LocalDate getDatedebutpae() {
		return datedebutpae;
	}

	public void setDatedebutpae(LocalDate datedebutpae) {
		this.datedebutpae = datedebutpae;
	}

	public LocalDate getDatefinpae() {
		return datefinpae;
	}

	public void setDatefinpae(LocalDate datefinpae) {
		this.datefinpae = datefinpae;
	}

	public LocalDate getDatecertification() {
		return datecertification;
	}

	public void setDatecertification(LocalDate datecertification) {
		this.datecertification = datecertification;
	}

	public String getNomsessionaveccentre() {
		return nomsessionaveccentre;
	}

	public void setNomsessionaveccentre(String nomsessionaveccentre) {
		this.nomsessionaveccentre = nomsessionaveccentre;
	}

	public Integer getIdcentre() {
		return idcentre;
	}

	public void setIdcentre(Integer idcentre) {
		this.idcentre = idcentre;
	}

	public Integer getIdformation() {
		return idformation;
	}

	public void setIdformation(Integer idformation) {
		this.idformation = idformation;
	}

	@Override
	public String toString() {
		return "SessionDto [idsession=" + idsession + ", nom=" + nom + ", datedebut=" + datedebut + ", datefin="
				+ datefin + ", datedebutpae=" + datedebutpae + ", datefinpae=" + datefinpae + ", datecertification="
				+ datecertification + ", nomsessionaveccentre=" + nomsessionaveccentre + ", idcentre=" + idcentre
				+ ", idformation=" + idformation + "]";
	}

	@Override
	public Integer getId() {
		return this.getIdsession();
	}

}
