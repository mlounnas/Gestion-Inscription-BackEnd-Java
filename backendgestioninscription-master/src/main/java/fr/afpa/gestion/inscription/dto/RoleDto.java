package fr.afpa.gestion.inscription.dto;

public class RoleDto extends Dto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idrole;
	private String code;
	
	public RoleDto() {
		super();
	}

	public RoleDto(Integer idrole, String code) {
		super();
		this.idrole = idrole;
		this.code = code;
	}

	public Integer getIdrole() {
		return idrole;
	}

	public void setIdrole(Integer idrole) {
		this.idrole = idrole;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((idrole == null) ? 0 : idrole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleDto other = (RoleDto) obj;
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
		return "RoleDto [idrole=" + idrole + ", code=" + code + "]";
	}

	@Override
	public Integer getId() {
		return this.getIdrole();
	}

	


}
