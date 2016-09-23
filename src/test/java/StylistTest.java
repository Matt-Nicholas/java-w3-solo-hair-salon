import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    assertEquals(true, testStylist instanceof Stylist);
  }
  @Test
  public void getId_stylistInstantiateWithAnId_1() {
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
  }
  @Test
  public void getName_stylistInstantiatesWithName_Alana() {
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    assertEquals("Alana", testStylist.getName());
  }
  @Test
  public void getExtention_stylistInstantiatesWithExtention_1() {
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    testStylist.save();
    assertEquals(1, testStylist.getExtention());
  }
  @Test
  public void getSpecialty_stylistInstantiatesWithSpecialty_1() {
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    testStylist.save();
    assertEquals("Colorist", testStylist.getSpecialty());
  }
  @Test
  public void find_returnsAllStylits_stylist2 (){
    Stylist stylist1 = new Stylist("Alana", 1, "Colorist");
    stylist1.save();
    Stylist stylist2 = new Stylist("Sarah", 2, "Hairdesigner");
    stylist2.save();
    assertEquals(Stylist.find(stylist2.getId()), stylist2);
  }
  @Test
  public void all_returnAllStylists_true(){
    Stylist firstStylist = new Stylist("Alana", 1, "Colorist");
    firstStylist.save();
    Stylist secondStylist = new Stylist("Sarah", 2, "Designer");
    secondStylist.save();
    assertEquals(true, Stylist.all().get(0).equals(firstStylist));
    assertEquals(true, Stylist.all().get(1).equals(secondStylist));
  }
  @Test
  public void updateExtention_updatesExtention_2(){
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    testStylist.save();
    testStylist.updateExtention(2);
    assertEquals(2, Stylist.find(testStylist.getId()).getExtention());

  }

  @Test
  public void updateSpecialty_updatesSpecialty_Hairdesigner(){
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    testStylist.save();
    testStylist.updateSpecialty("Hairdesigner");
    assertEquals("Hairdesigner", Stylist.find(testStylist.getId()).getSpecialty());

  }
  @Test
  public void delete_deletesStylist_true() {
    Stylist testStylist = new Stylist("Alana", 1, "Colorist");
    testStylist.save();
    int testStylistId = testStylist.getId();
    testStylist.delete();
    assertEquals(null, Stylist.find(testStylistId));
  }

}
