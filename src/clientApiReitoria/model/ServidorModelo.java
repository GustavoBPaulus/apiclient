package clientApiReitoria.model;

import java.util.ArrayList;
import java.util.List;


public class ServidorModelo {
 String senha;
 String data_nascimento;
 String login;
 List<ServidorCargoModelo> listaCargos = new ArrayList<ServidorCargoModelo>();
 String sexo;
 String nome_completo;
 String email;
 
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
public String getData_nascimento() {
	return data_nascimento;
}
public void setData_nascimento(String data_nascimento) {
	this.data_nascimento = data_nascimento;
}
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public List<ServidorCargoModelo> getListaCargos() {
	return listaCargos;
}
public void setListaCargos(List<ServidorCargoModelo> listaCargos) {
	this.listaCargos = listaCargos;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getNome_completo() {
	return nome_completo;
}
public void setNome_completo(String nome_completo) {
	this.nome_completo = nome_completo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "ServidorModelo [senha=" + senha + ", data_nascimento=" + data_nascimento + ", login=" + login
			+ ", listaCargos=" + listaCargos + ", sexo=" + sexo + ", nome_completo=" + nome_completo + ", email="
			+ email + "]";
}



 
 
}
