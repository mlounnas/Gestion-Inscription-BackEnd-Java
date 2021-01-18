package fr.afpa.gestion.inscription.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Session.findAll", query = "SELECT u FROM Session u")
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsession")
	private Integer idsession;

	@Column(length = 50, nullable = false)
	private String nom;

	@Column(nullable = false, name = "datedebut")

	private LocalDate datedebut;

	@Column(nullable = false, name = "datefin")
	private LocalDate datefin;

	@Column(nullable = true, name = "datedebutpae")
	private LocalDate datedebutpae;

	@Column(nullable = true, name = "datefinpae")
	private LocalDate datefinpae;

	@Column(nullable = true, name = "datecertification")
	private LocalDate datecertification;

	@Column(length = 50, unique = true, nullable = false, name = "nomsessionaveccentre")
	private String nomsessionaveccentre;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idformation")
	private Formation formation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcentre")
	private Centre centre;

	@OneToMany(mappedBy = "session", fetch = FetchType.LAZY)
	private List<Utilisateur> utilisateurs;

	public Session() {
		super();
	}
	
	

	public Session(Integer idsession, String nom, LocalDate datedebut, LocalDate datefin, LocalDate datedebutpae,
			LocalDate datefinpae, LocalDate datecertification, String nomsessionaveccentre, Formation formation,
			Centre centre) {
		super();
		this.idsession = idsession;
		this.nom = nom;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.datedebutpae = datedebutpae;
		this.datefinpae = datefinpae;
		this.datecertification = datecertification;
		this.nomsessionaveccentre = nomsessionaveccentre;
		this.formation = formation;
		this.centre = centre;
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

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((datecertification == null) ? 0 : datecertification.hashCode());
		result = prime * result + ((datedebut == null) ? 0 : datedebut.hashCode());
		result = prime * result + ((datedebutpae == null) ? 0 : datedebutpae.hashCode());
		result = prime * result + ((datefin == null) ? 0 : datefin.hashCode());
		result = prime * result + ((datefinpae == null) ? 0 : datefinpae.hashCode());
		result = prime * result + ((formation == null) ? 0 : formation.hashCode());
		result = prime * result + ((idsession == null) ? 0 : idsession.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((nomsessionaveccentre == null) ? 0 : nomsessionaveccentre.hashCode());
		result = prime * result + ((utilisateurs == null) ? 0 : utilisateurs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Session other = (Session) obj;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (datecertification == null) {
			if (other.datecertification != null)
				return false;
		} else if (!datecertification.equals(other.datecertification))
			return false;
		if (datedebut == null) {
			if (other.datedebut != null)
				return false;
		} else if (!datedebut.equals(other.datedebut))
			return false;
		if (datedebutpae == null) {
			if (other.datedebutpae != null)
				return false;
		} else if (!datedebutpae.equals(other.datedebutpae))
			return false;
		if (datefin == null) {
			if (other.datefin != null)
				return false;
		} else if (!datefin.equals(other.datefin))
			return false;
		if (datefinpae == null) {
			if (other.datefinpae != null)
				return false;
		} else if (!datefinpae.equals(other.datefinpae))
			return false;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (idsession == null) {
			if (other.idsession != null)
				return false;
		} else if (!idsession.equals(other.idsession))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (nomsessionaveccentre == null) {
			if (other.nomsessionaveccentre != null)
				return false;
		} else if (!nomsessionaveccentre.equals(other.nomsessionaveccentre))
			return false;
		if (utilisateurs == null) {
			if (other.utilisateurs != null)
				return false;
		} else if (!utilisateurs.equals(other.utilisateurs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Session [idsession=" + idsession + ", nom=" + nom + ", datedebut=" + datedebut + ", datefin=" + datefin
				+ ", datedebutpae=" + datedebutpae + ", datefinpae=" + datefinpae + ", datecertification="
				+ datecertification + ", nomsessionaveccentre=" + nomsessionaveccentre + ", formation=" + formation
				+ ", centre=" + centre + "]";
	}

}
