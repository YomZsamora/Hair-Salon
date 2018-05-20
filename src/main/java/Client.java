import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
   private String client_first_name;
   private String client_last_name;
   private String client_phone_no;
   private int stylistid;
   private LocalDateTime createdAt;

   private int id;

   public Client(String clientFirstName, String clientLastName, String clientPhone, int stylistId) {
      this.client_first_name = clientFirstName;
      this.client_last_name = clientLastName;
      this.client_phone_no = clientPhone;
      this.stylistid = stylistId;
      createdAt = LocalDateTime.now();
   }

   public String getClientFirstName() {
      return client_first_name;
   }

   public String getClientLastName() {
      return client_last_name;
   }

   public String getClientPhoneNo() {
      return client_phone_no;
   }

   public int getClientStylistId() {
      return stylistid;
   }

   public LocalDateTime getClientCreatedAt() {
      return createdAt;
   }

   public int getClientId() {
      return id;
   }

   public static Client find(int id) {
      try(Connection con = DB.sql2o.open()) {
         String sql = "SELECT * FROM clients where id=:id";
         Client client = con.createQuery(sql)
         .addParameter("id", id)
         .executeAndFetchFirst(Client.class);
         return client;
      }
   }

   public void save() {
      try(Connection con = DB.sql2o.open()) {
         String sql = "INSERT INTO clients(client_first_name, client_last_name, client_phone_no, stylistid) VALUES (:client_first_name, :client_last_name, :client_phone_no, :stylistid)";
         this.id = (int) con.createQuery(sql, true)
         .addParameter("client_first_name", this.client_first_name)
         .addParameter("client_last_name", this.client_last_name)
         .addParameter("client_phone_no", this.client_phone_no)
         .addParameter("stylistid", this.stylistid)
         .executeUpdate()
         .getKey();
      }
   }

   public void update(String client_first_name, String client_last_name, String client_phone_no) {
      try(Connection con = DB.sql2o.open()) {
         String sql = "UPDATE clients SET client_first_name = :client_first_name, client_last_name = :client_last_name, client_phone_no = :client_phone_no  WHERE id = :id";
         con.createQuery(sql)
         .addParameter("client_first_name", client_first_name)
         .addParameter("client_last_name", client_last_name)
         .addParameter("client_phone_no", client_phone_no)
         .addParameter("id", id)
         .executeUpdate();
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
}
