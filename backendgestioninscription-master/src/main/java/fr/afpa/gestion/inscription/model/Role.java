package fr.afpa.gestion.inscription.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrole")
	private Integer idrole;

	@Column(length = 10, unique = true, nullable = false)
	private String code;

	public Role() {
	}

	public Role(String code) {
		super();
		this.code = code;
	}

	public Integer getIdrole() {
		return this.idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idrole == null) ? 0 : idrole.hashCode());
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
		Role other = (Role) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (idrole == null) {
			if (other.idrole != null)
				return false;
		} else if (!idrole.equals(other.idrole))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [idrole=" + idrole + ", code=" + code + "]";
	}

}