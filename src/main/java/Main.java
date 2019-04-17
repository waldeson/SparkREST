import static spark.Spark.*;
import static spark.Spark.get;
import static spark.Spark.post;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		SimpleDateFormat diaMesAno = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		SimpleDateFormat horas = new SimpleDateFormat("hh:mm");
		get("/hello", (req, res) -> {
			return "Hello World" + " " + diaMesAno.format(new Date());
		});
		post("/hello", (req, res) -> {
			System.out.println(horas.format(new Date()));
			return req.body();
		});		
//
//		put("/hello/testePut", (request, response) -> {
//		    // Update something
//		});
//
//		delete("/hello/testeDelete", (request, response) -> {
//		    // Annihilate something
//		});
//
//		options("/hello/testeOptions", (request, response) -> {
//		    // Appease something
//		});
	}

	private static Objeto convertJsonToObjeto(String json) {
		try {
			Type type = new TypeToken<Objeto>() {
			}.getType();
			Gson gson = new Gson();
			Object objectReturn = gson.fromJson(json, type);
			System.out.println(objectReturn);
			return (Objeto) objectReturn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}