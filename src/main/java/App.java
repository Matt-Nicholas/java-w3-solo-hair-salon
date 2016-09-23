import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("stylists", Stylist.all());
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/admin", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/admin.vtl");
          model.put("stylists", Stylist.all());
          model.put("clients", Client.all());
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/stylist/new", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          String name = request.queryParams("name");
          int extention = Integer.parseInt(request.queryParams("extention"));
          String specialty = request.queryParams("specialty");
          String bio = request.queryParams("bio");
          String image_src = request.queryParams("image_src");
          Stylist stylist = new Stylist(name, extention, specialty, bio, image_src);
          stylist.save();
          model.put("stylist", stylist);
          model.put("template", "templates/stylist.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/stylist/:id", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
          model.put("clients", Client.all());
          model.put("stylist", stylist);
          model.put("template", "templates/stylist.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        post("/stylist/:id/update", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));

          int extention = Integer.parseInt(request.queryParams("extention"));
          String specialty = request.queryParams("specialty");
          String bio = request.queryParams("bio");
          String image_src = request.queryParams("image_src");
          stylist.updateExtention(extention);
          stylist.updateBio(bio);
          stylist.updateSpecialty(specialty);
          model.put("stylist", stylist);
          model.put("template", "templates/stylist.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/stylist/:id/client/new", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
          String name = request.queryParams("name");
          int stylist_id = Integer.parseInt(request.queryParams("stylist_id"));
          String phone = request.queryParams("phone");
          Client client = new Client(name, stylist_id, phone);
          client.save();
          model.put("clients", Client.all());
          model.put("stylist", stylist);
          model.put("template", "templates/stylist.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/client/:id", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Client client = Client.find(Integer.parseInt(request.params(":id")));
          int stylist_id = Integer.parseInt(request.queryParams("stylist_id"));
          String phone = request.queryParams("phone");
          client.updateStylistId(stylist_id);
          client.updatePhone(phone);
          model.put("client", client);
          model.put("template", "templates/client.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/client/:id", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Client client = Client.find(Integer.parseInt(request.params(":id")));
          model.put("client", client);
          model.put("template", "templates/client.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



        post("/stylist/:stylist_id/client/:id/delete", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylist_id")));
          Client client = Client.find(Integer.parseInt(request.params(":id")));
          client.delete();
          model.put("clients", Client.all());
          model.put("stylist", stylist);
          model.put("template", "templates/stylist.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());



    }
}
