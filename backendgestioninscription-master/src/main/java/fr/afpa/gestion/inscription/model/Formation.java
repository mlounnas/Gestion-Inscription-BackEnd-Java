package fr.afpa.gestion.inscription.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Formation.findAll", query = "SELECT u FROM Formation u")

public class Formation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idformation")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idformation;

	@Column(length = 50, unique = true, nullable = false)
	private String intitule;

	@OneToMany(mappedBy = "formation")

	private List<Session> sessions;

	public Formation() {
		super();
	}

	public Formation(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Integer getIdformation() {
		return idformation;
	}

	public void setIdformation(Integer idformation) {
		this.idformation = idformation;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idformation == null) ? 0 : idformation.hashCode());
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
		result = prime * result + ((sessions == null) ? 0 : sessions.hashCode());
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
		Formation other = (Formation) obj;
		if (idformation == null) {
			if (other.idformation != null)
				return false;
		} else if (!idformation.equals(other.idformation))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		if (sessions == null) {
			if (other.sessions != null)
				return false;
		} else if (!sessions.equals(other.sessions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Formation [idformation=" + idformation + ", intitule=" + intitule + "]";
	}

}
