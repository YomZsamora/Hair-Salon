import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
private String first_name;
private String last_name;
private int age;
private String phone_no;
private String department;
private LocalDateTime createdAt;

private int id;

public Stylist(String stylistFirstName, String stylistLastName, int stylistAge, String stylistPhone, String stylistDept) {
   this.first_name = stylistFirstName;
   this.last_name = stylistLastName;
   this.age = stylistAge;
   this.phone_no = stylistPhone;
   this.department = stylistDept;
   createdAt = LocalDateTime.now();
}

public String getStylistFirstName() {
   return first_name;
}

public String getStylistLastName() {
   return last_name;
}

public int getStylistAge() {
   return age;
}

public String getStylistPhoneNo() {
   return phone_no;
}

public String getStylistDept() {
   return department;
}

public LocalDateTime getStylistCreatedAt() {
   return createdAt;
}

public int getStylistId() {
   return id;
}

public static List<Stylist> all() {
   String sql = "SELECT id, first_name, last_name, age, phone_no, department FROM stylists";
      try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
   }
}

// public static Stylist find(int id) {
// }

  // public String getName() {
  //   return name;
  // }

  

  // public int getId() {
  //   return id;
  // }

  // public List<Task> getTasks() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM tasks where categoryId=:id";
  //     return con.createQuery(sql)
  //     .addParameter("id", this.id)
  //     .executeAndFetch(Task.class);
  //   }
  // }

  // public static Category find(int id) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM categories where id=:id";
  //     Category category = con.createQuery(sql)
  //     .addParameter("id", id)
  //     .executeAndFetchFirst(Category.class);
  //     return category;
  //   }
  // }

public void save() {
   try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(first_name, last_name, age, phone_no, department) VALUES (:stylistFirstName, :stylistLastName, :stylistAge, :stylistPhone, :stylistDept)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("first_name", this.first_name)
      .addParameter("last_name", this.last_name)
      .addParameter("age", this.age)
      .addParameter("phone_no", this.phone_no)
      .addParameter("department", this.department)
      .executeUpdate()
      .getKey();
   }
}

  // @Override
  // public boolean equals(Object otherCategory) {
  //   if (!(otherCategory instanceof Category)) {
  //     return false;
  //   } else {
  //     Category newCategory = (Category) otherCategory;
  //     return this.getName().equals(newCategory.getName()) &&
  //     this.getId() == newCategory.getId();
  //   }
  // }

}
