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
    @Override
    public boolean equals(Object otherClient) {
        if (!(otherClient instanceof Client)) {
            return false;
        } else {
            Client newClient = (Client) otherClient;
            return this.getName().equals(newClient.getName()) &&
            this.getId() == newClient.getId();
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO clients (name, stylist_id, phone_number) VALUES (:name, :stylist_id, :phone_number)";
            this.id = (int) con.createQuery(sql, true)
            .addParameter("name", this.name)
            .addParameter("stylist_id", this.stylist_id)
            .addParameter("phone_number", this.phone_number)
            .executeUpdate()
            .getKey();
        }
    }
    public static Client find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM clients WHERE id=:id";
            Client client = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Client.class);
            return client;
        }
    }
    public static List<Client> all(){
        try(Connection con= DB.sql2o.open()){
            String sql = "SELECT id, name, stylist_id, phone_number FROM clients";
            return con.createQuery(sql).executeAndFetch(Client.class);
        }
    }
    public static Client findByPhone(String phone_number){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM clients WHERE phone_number=:phone_number";
            Client client = con.createQuery(sql)
            .addParameter("phone_number", phone_number)
            .executeAndFetchFirst(Client.class);
            return client;
        }
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM clients WHERE id = :id;";
            con.createQuery(sql)
            .addParameter("id", id)
            .executeUpdate();
        }
    }
    public void updateStylistId(int stylist_id){
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE clients SET stylist_id = :stylist_id WHERE id = :id";
            con.createQuery(sql)
            .addParameter("stylist_id", stylist_id)
            .addParameter("id", id)
            .executeUpdate();
        }
    }
    public void updatePhone(String phone_number){
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE clients SET phone_number = :phone_number WHERE id = :id";
            con.createQuery(sql)
            .addParameter("phone_number", phone_number)
            .addParameter("id", id)
            .executeUpdate();
        }
    }
}
