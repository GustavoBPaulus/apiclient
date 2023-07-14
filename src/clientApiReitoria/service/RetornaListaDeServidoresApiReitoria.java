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

import clientApiReitoria.model.ServidorCargoModelo;
import clientApiReitoria.model.ServidorModelo;

import useful.JsonUtil;

public class RetornaListaDeServidoresApiReitoria {

	public List<ServidorModelo> retornaListaDeServidores() {
		String servico = "servidores".trim();

		String chave = "4c3f227847454d4455222d5b58475b4d".trim();
		String usuario = "ibiruba".trim();
		String senha = "LyMzJ6cS".trim();

		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(usuario, senha);

		Client client = ClientBuilder.newClient();
		client.register(feature);

		WebTarget target = client.target("https://api.ifrs.edu.br/sig/service/" + servico + "/chave/" + chave);

		Invocation.Builder invocador = target.request(MediaType.APPLICATION_JSON);

		Response response = invocador.get();

		String output = response.readEntity(String.class);

		System.out.println(output);

		List<ServidorModelo> listaDeServidores = new ArrayList<ServidorModelo>();

		List<JSONObject> listJsonObject = JsonUtil.retornaListJsonComUtfCorreto(output);

		/*
		 * aqui percorro a lista e em cada objeto seleciono o valor dos diferentes
		 * atributos do tipo aluno
		 */
		for (JSONObject servidorJson : listJsonObject) {
			// AlunoModel aluno = new AlunoModel();
			// System.out.println(servidorJson);
			// List<AlunoCursoModelo> listaAlunoCurso = new ArrayList<AlunoCursoModelo>();
			ServidorModelo servidor = new ServidorModelo();

			List<ServidorCargoModelo> listaCargosServidor = new ArrayList<ServidorCargoModelo>();

			// System.out.println(servidorJson.get("cargos"));
			JSONArray cargoServidorJsonArray = servidorJson.getJSONArray("cargos");

			for (int i = 0; i < cargoServidorJsonArray.length(); i++) {
				JSONObject cargoServidorJsonObject = cargoServidorJsonArray.getJSONObject(i);
				System.out.println(cargoServidorJsonObject.toString());
				ServidorCargoModelo servidorCargo = new ServidorCargoModelo();

				// System.out.println(cargoServidorJsonObject.getString("matricula"));
				servidorCargo.setMatricula(cargoServidorJsonObject.getString("matricula"));

				// System.out.println(cargoServidorJsonObject.getString("cargo"));
				servidorCargo.setCargo(cargoServidorJsonObject.getString("cargo"));

				servidorCargo.setStatus(cargoServidorJsonObject.getString("status"));

				String loginSemAspas = JsonUtil.removeDoubleQuotes(servidorJson.getString("login"));
				servidorCargo.setLogin(loginSemAspas);

				listaCargosServidor.add(servidorCargo);
			}

			servidor.setListaCargos(listaCargosServidor);

			// System.out.println(servidorJson.getString("login"));
			servidor.setLogin(servidorJson.getString("login"));

			// System.out.println(servidorJson.getString("senha"));
			// servidor.setSenha(servidor.getLogin()+"@ibiruba.ifrs");

			// System.out.println(servidorJson.getString("data_nascimento"));
			servidor.setData_nascimento(servidorJson.getString("data_nascimento"));

			// System.out.println(servidorJson.getString("sexo"));
			servidor.setSexo(servidorJson.getString("sexo"));
			try {
				System.out.println(servidorJson.getString("email"));
				if (servidorJson.getString("email") != null && !servidorJson.getString("email").equalsIgnoreCase(""))
					servidor.setEmail(servidorJson.getString("email"));
				else
					servidor.setEmail("sememail@sememail.com");
			} catch (org.json.JSONException e) {
				servidor.setEmail("sememail@sememail.com");
			}
			// System.out.println(servidorJson.getString("nome_completo"));
			servidor.setNome_completo(servidorJson.getString("nome_completo"));

			// System.out.println(Servidor.toString());

			listaDeServidores.add(servidor);
		}

		return listaDeServidores;
	}

	public static void main(String[] args) {
		new RetornaListaDeServidoresApiReitoria().retornaListaDeServidores();
	}

}
