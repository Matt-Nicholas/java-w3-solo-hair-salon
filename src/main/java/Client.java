import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;
  private int stylist_id;
  private String phone_number;

  public Client(String name, int stylist_id, String phone_number) {
    this.name = name;
    this.stylist_id = stylist_id;
    this.phone_number = phone_number;
  }

  // Getters
    public int getId(){
      return id;
    }
    public String getName(){
      return name;
    }
    public int getStylistId(){
      return stylist_id;
    }
    public String getPhoneNumber(){
      return phone_number;
    }

}
