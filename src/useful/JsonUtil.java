package useful;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;

public class JsonUtil {

	private static final Charset UTF_8 = Charset.forName("UTF-8");
	private static final Charset ISO = Charset.forName("ISO-8859-1");

	
	public static List<JSONObject> retornaListJsonComUtfCorreto(String output) {
		String retorno = new String(output.getBytes(ISO), UTF_8);
		List<JSONObject> listJsonObject = new ArrayList<JSONObject>();
		
		JSONObject jsonObject = new JSONObject(retorno);
		Set<String> keys = jsonObject.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {		
		JSONObject jsonIndividual	= (JSONObject) jsonObject.get(it.next());
			listJsonObject.add(jsonIndividual);
		/*
		Set<String> chavesPorComponente = (Set<String>) jsonIndividual.keySet();
		 chavesPorComponente.forEach(s ->{
			 System.out.println(s);
		 });
		*/
		
		}
		return listJsonObject;
	}
	
	

    public static String removeDoubleQuotes(String input){

	StringBuilder sb = new StringBuilder();
	
	char[] tab = input.toCharArray();
	for( char current : tab ){
	    if( current != '"' )
		sb.append( current );	
	}
	
	return sb.toString();
    }

	
}
