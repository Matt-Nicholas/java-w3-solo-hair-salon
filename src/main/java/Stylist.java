import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private int id;
  private String name;
  private int extention;
  private String specialty;

  public Stylist(String name, int extention, String specialty) {
    this.name = name;
    this.extention = extention;
    this.specialty = specialty;
  }
// Getters
  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public int getExtention(){
    return extention;
  }
  public String getSpecialty(){
    return specialty;
  }

  @Override
  public boolean equals(Object otherStylist) {
    if (!(otherStylist instanceof Stylist)) {
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getName().equals(newStylist.getName()) &&
             this.getId() == newStylist.getId();
    }
  }

  public static Stylist find(int id){
    try(Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM stylists WHERE id=:id";
      Stylist stylist = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, extention, specialty) VALUES (:name, :extention, :specialty)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("extention", this.extention)
        .addParameter("specialty", this.specialty)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Stylist> all(){
    try(Connection con= DB.sql2o.open()){
      String sql = "SELECT id, name, extention, specialty FROM stylists";
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public void updateExtention(int extention){
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET extention = :extention WHERE id = :id";
      con.createQuery(sql)
        .addParameter("extention", extention)
        .addParameter("id", id)
        .executeUpdate();
      }
  }
}
