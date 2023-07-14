package clientApiReitoria.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.json.JSONArray;
import org.json.JSONObject;
import clientApiReitoria.model.AlunoCursoModelo;
import clientApiReitoria.model.AlunoModel;
import useful.JsonUtil;


public class RetornaListaDeAlunosApiReitoria {

	public List<AlunoModel> retornaListaDeAlunos() {
		String servico = "alunos".trim();

		String chave = "4c3f227847454d4455222d5b58475b4d".trim();
		String usuario = "ibiruba".trim();
		String senha = "LyMzJ6cS".trim();

		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(usuario, senha);

		Client client = ClientBuilder.newClient();
		client.register(feature);

		WebTarget target = client.target("https://api.ifrs.edu.br/sig/service/" + servico + "/chave/" + chave);

		Invocation.Builder invocador = target.request(MediaType.APPLICATION_JSON);

		Response response = invocador.get();
		
		System.out.println(response.getStatus()); 
		String output = response.readEntity(String.class);

		System.out.println(output);

		List<AlunoModel> listaDeAlunos = new ArrayList<AlunoModel>();
		//// System.out.println(output);
		List<JSONObject> listJsonObject = JsonUtil.retornaListJsonComUtfCorreto(output);

		/*
		 * aqui percorro a lista e em cada objeto seleciono o valor dos diferentes
		 * atributos do tipo aluno
		 */
		for (JSONObject alunoJson : listJsonObject) {
			AlunoModel aluno = new AlunoModel();

			List<AlunoCursoModelo> listaAlunoCurso = new ArrayList<AlunoCursoModelo>();

			// System.out.println(alunoJson.get("cursos"));
			JSONArray cursoAlunoJsonArray = alunoJson.getJSONArray("cursos");

			for (int i = 0; i < cursoAlunoJsonArray.length(); i++) {
				JSONObject cursoAlunoJsonObject = cursoAlunoJsonArray.getJSONObject(i);
				AlunoCursoModelo alunoCurso = new AlunoCursoModelo();

				// System.out.println(cursoAlunoJsonObject.getString("nome_curso"));
				alunoCurso.setNome_curso(cursoAlunoJsonObject.getString("nome_curso"));

				// System.out.println(cursoAlunoJsonObject.getString("turma_entrada"));
				alunoCurso.setTurma_entrada(cursoAlunoJsonObject.getString("turma_entrada"));

				// System.out.println(cursoAlunoJsonObject.getString("matricula"));
				alunoCurso.setMatricula(cursoAlunoJsonObject.getString("matricula"));

				// System.out.println(cursoAlunoJsonObject.getString("curriculo"));
				alunoCurso.setCurriculo(cursoAlunoJsonObject.getString("curriculo"));

				// System.out.println("Código curso:
				// "+cursoAlunoJsonObject.get("cod_curso").toString());
				alunoCurso.setCod_curso(cursoAlunoJsonObject.get("cod_curso").toString());

				// System.out.println(cursoAlunoJsonObject.getString("status_discente"));
				alunoCurso.setStatus_discente(cursoAlunoJsonObject.getString("status_discente"));

				String loginSemAspas = JsonUtil.removeDoubleQuotes(alunoJson.getString("login"));
				alunoCurso.setLogin(loginSemAspas);
				//não adiciona alunos que não tem status ativo ou formando
				if(alunoCurso.getStatus_discente().equalsIgnoreCase("ATIVO") || 
						alunoCurso.getStatus_discente().equalsIgnoreCase("FORMANDO"))
					listaAlunoCurso.add(alunoCurso);
			}

			aluno.setCursosAluno(listaAlunoCurso);

			 System.out.println(alunoJson.get("data_nascimento").toString());
			aluno.setData_nascimento(alunoJson.get("data_nascimento").toString());

			 System.out.println(alunoJson.get("email").toString());
			if(alunoJson.get("email").toString() != null && alunoJson.get("email").toString() != "") 
				aluno.setEmail(alunoJson.get("email").toString().toLowerCase());
			else aluno.setEmail("sememail@semmail.com");

			/*
			 * ////System.out.println(alunoJson.get("foto"));
			 * aluno.setFoto(alunoJson.getString("foto"));
			 */

			//// System.out.println(alunoJson.getString("login"));
			aluno.setLogin(alunoJson.getString("login"));

			//// System.out.println(alunoJson.getString("nome_completo"));
			aluno.setNome_completo(alunoJson.getString("nome_completo"));

			//// System.out.println(alunoJson.getString("senha"));
			//aluno.setSenha(aluno.getLogin() + "@ibiruba.ifrs");

			//// System.out.println(alunoJson.getString("sexo"));
			aluno.setSexo(alunoJson.getString("sexo"));

			//adiciona apenas alunos com curso vinculado
			if(aluno.getCursosAluno().size() >= 1)
				listaDeAlunos.add(aluno);

		}
		
		
		return listaDeAlunos;
	}

	public static void main(String[] args) {
		new RetornaListaDeAlunosApiReitoria().retornaListaDeAlunos();
	}
}
