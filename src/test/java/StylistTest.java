import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

   @Before
   public void setUp() {
      DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon", null, null);
   }

   @After
   public void tearDown() {
      try(Connection con = DB.sql2o.open()) {
         String deleteTasksQuery = "DELETE FROM clients *;";
         String deleteCategoriesQuery = "DELETE FROM stylists *;";
         con.createQuery(deleteTasksQuery).executeUpdate();
         con.createQuery(deleteCategoriesQuery).executeUpdate();
      }
   }

   
}
