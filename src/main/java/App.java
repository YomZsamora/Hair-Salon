import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  	public static void main(String[] args) {
      ProcessBuilder process = new ProcessBuilder();
      Integer port;
      if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
      } else {
         port = 4567;
      }
      setPort(port);

    	staticFileLocation("/public");
    	String layout = "templates/layout.vtl";

    	get("/", (request, response) -> {
      	Map<String, Object> model = new HashMap<String, Object>();
      	model.put("template", "templates/index.vtl");
      	return new ModelAndView(model, layout);
    	}, new VelocityTemplateEngine());

      get("/stylists", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("stylists", Stylist.all());
         model.put("template", "templates/stylists.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/addStylist", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("template", "templates/addStylist.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/addStylist", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         String stylistFirstName = request.queryParams("stylistFirstName");
         String stylistLastName = request.queryParams("stylistLastName");
         int stylistAge = Integer.parseInt(request.queryParams("stylistAge"));
         String stylistPhone = request.queryParams("stylistPhone");
         String stylistDept = request.queryParams("stylistDept");
         Stylist newStylist = new Stylist(stylistFirstName, stylistLastName, stylistAge, stylistPhone, stylistDept);
         newStylist.save();
         model.put("template", "templates/addStylist.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/deleteStylist/:id", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
         model.put("stylist", stylist);
         model.put("template", "templates/deleteStylist.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/updateStylist", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("template", "templates/updateStylist.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/addClient", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("template", "templates/addClient.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/viewClients", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         model.put("template", "templates/viewClients.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  	}
}