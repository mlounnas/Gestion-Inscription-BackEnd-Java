package fr.afpa.gestion.inscription.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t")
public class Theme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtheme")
	private Integer idtheme;

	@Column(length = 30, unique = true, nullable = false)
	private String nom;

	@Column(length = 10, nullable = true)
	private String couleur;

	@Column(length = 300, nullable = true)
	private String description;

	@Column(length = 600, nullable = true)
	private String descriptiondetaillee;

	public Theme() {
		super();
	}

	public Theme(String nom, String couleur, String description, String descriptionDetaillee) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.description = description;
		this.descriptiondetaillee = descriptionDetaillee;

	}

	public Integer getIdtheme() {
		return idtheme;
	}

	public void setIdtheme(Integer idtheme) {
		this.idtheme = idtheme;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptiondetaillee() {
		return descriptiondetaillee;
	}

	public void setDescriptiondetaillee(String descriptiondetaillee) {
		this.descriptiondetaillee = descriptiondetaillee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((descriptiondetaillee == null) ? 0 : descriptiondetaillee.hashCode());
		result = prime * result + ((idtheme == null) ? 0 : idtheme.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Theme other = (Theme) obj;
		if (couleur == null) {
			if (other.couleur != null)
				return false;
		} else if (!couleur.equals(other.couleur))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (descriptiondetaillee == null) {
			if (other.descriptiondetaillee != null)
				return false;
		} else if (!descriptiondetaillee.equals(other.descriptiondetaillee))
			return false;
		if (idtheme == null) {
			if (other.idtheme != null)
				return false;
		} else if (!idtheme.equals(other.idtheme))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Theme [idtheme=" + idtheme + ", nom=" + nom + ", couleur=" + couleur + ", description=" + description
				+ ", descriptiondetaillee=" + descriptiondetaillee + "]";
	}

}
