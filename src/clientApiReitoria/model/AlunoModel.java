package clientApiReitoria.model;

import java.util.List;


public class AlunoModel {
	
	private String login;
	private String nome_completo;
	private String senha;
	private String email;
	private String data_nascimento;
	private String sexo;
	
	
	
	private List<AlunoCursoModelo> listaCursosAluno; 
	
	
	
	
	public List<AlunoCursoModelo> getCursosAluno() {
		return listaCursosAluno;
	}
	public void setCursosAluno(List<AlunoCursoModelo> cursosAluno) {
		this.listaCursosAluno = cursosAluno;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
		
	
}
