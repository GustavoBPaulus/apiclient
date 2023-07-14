package clientApiReitoria.model;


public class AlunoCursoModelo {
	private String nome_curso;
	private String turma_entrada;
	private String matricula;
	private String curriculo;
	private String cod_curso;
	private String status_discente;
	private String login;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getStatus_discente() {
		return status_discente;
	}
	public void setStatus_discente(String status_discente) {
		this.status_discente = status_discente;
	}
	public String getNome_curso() {
		return nome_curso;
	}
	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}
	public String getTurma_entrada() {
		return turma_entrada;
	}
	public void setTurma_entrada(String turma_entrada) {
		this.turma_entrada = turma_entrada;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurriculo() {
		return curriculo;
	}
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	public String getCod_curso() {
		return cod_curso;
	}
	public void setCod_curso(String cod_curso) {
		this.cod_curso = cod_curso;
	}

	
	
}
