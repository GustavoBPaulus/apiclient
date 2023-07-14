package clientApiReitoria.model;



public class ServidorCargoModelo {
	String matricula;
	String cargo;
	String login;
	String status;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ServidorCargoModelo [matricula=" + matricula + ", cargo=" + cargo + ", login=" + login + ", status="
				+ status + "]";
	}
	
	
	
	
}
