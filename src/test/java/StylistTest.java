import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Alana");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_stylistInstantiatesWithName_Alana() {
    Stylist testStylist = new Stylist("Alana");
    assertEquals("Alana", testStylist.getName());
  }

  @Test
   public void getId_stylistInstantiateWithAnId_1() {
     Stylist testStylist = new Stylist("Alana");
     testStylist.save();
     assertTrue(testStylist.getId() > 0);
   }
   @Test
   public void find_returnsAllStylits_stylist2 (){
     Stylist stylist1 = new Stylist("Alana");
     stylist1.save();
     Stylist stylist2 = new Stylist("Sarah");
     stylist2.save();
     assertEquals(Stylist.find(stylist2.getId()), stylist2);
   }




}
