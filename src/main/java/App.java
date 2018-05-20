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

      post("/deleteStylist/:id", (request, response) -> {
         HashMap<String, Object> model = new HashMap<String, Object>();
         Stylist stylist = Stylist.find(Integer.parseInt(request.params("id")));
         stylist.delete();
         model.put("stylists", Stylist.all());
         model.put("template", "templates/stylists.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/updateStylist/:id", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
         model.put("stylist", stylist);
         model.put("template", "templates/updateStylist.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/updateStylist/:id", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
         String first_name = request.queryParams("stylistFirstName");
         String last_name = request.queryParams("stylistLastName");
         int age = Integer.parseInt(request.queryParams("stylistAge"));
         String phone_no = request.queryParams("stylistPhone");
         String department = request.queryParams("stylistDept");
         stylist.update(first_name,last_name,age,phone_no,department);
         String url = String.format("/updateStylist/%d", stylist.getStylistId());
         response.redirect(url);
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/addClient/:id", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
         model.put("stylist", stylist);
         model.put("template", "templates/addClient.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/addClient", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Stylist stylist = Stylist.find(Integer.parseInt(request.queryParams("stylistId")));
         String clientFirstName = request.queryParams("clientFirstName");
         String clientLastName = request.queryParams("clientLastName");
         String clientPhoneNo = request.queryParams("clientPhoneNo");
         Client newClient = new Client(clientFirstName, clientLastName, clientPhoneNo, stylist.getStylistId());
         newClient.save();
         model.put("stylist", stylist);
         model.put("template", "templates/addClient.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/viewClients/:id", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
         model.put("stylist", stylist);
         model.put("template", "templates/viewClients.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/updateClient/:id", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Client client = Client.find(Integer.parseInt(request.params(":id")));
         model.put("client", client);
         model.put("template", "templates/updateClient.vtl");
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/updateClient/:id", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         Client client = Client.find(Integer.parseInt(request.params(":id")));
         String client_first_name = request.queryParams("clientFirstName");
         String client_last_name = request.queryParams("clientLastName");
         String client_phone_no = request.queryParams("clientPhoneNo");
         client.update(client_first_name,client_last_name,client_phone_no);
         String url = String.format("/updateClient/%d", client.getClientId());
         response.redirect(url);
         return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
  	}
}