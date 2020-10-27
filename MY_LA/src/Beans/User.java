package Beans;

public class User {
	
	private String login;
	private String parol;
	private String satus;
	
	

	public User(String login, String parol) {
		
		this.login = login;
		this.parol = parol;
		this.satus = "junior";
	}
	public User(String login, String parol, String status) {
		this.login = login;
		this.parol = parol;
		this.satus = status;
	}
	public User() {
		this.satus = "junior";	
		}
	@Override
	public String toString() {
		return "User [ login = " + login + " , parol = " + parol + " , satus = " + satus + " ]";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getParol() {
		return parol;
	}
	public void setParol(String parol) {
		this.parol = parol;
	}
	public String getSatus() {
		return satus;
	}
	public void setSatus(String satus) {
		this.satus = satus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((parol == null) ? 0 : parol.hashCode());
		result = prime * result + ((satus == null) ? 0 : satus.hashCode());
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
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (parol == null) {
			if (other.parol != null)
				return false;
		} else if (!parol.equals(other.parol))
			return false;
		if (satus == null) {
			if (other.satus != null)
				return false;
		} else if (!satus.equals(other.satus))
			return false;
		return true;
	}
	

	
}
