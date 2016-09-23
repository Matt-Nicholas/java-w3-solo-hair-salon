import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void client_instantiatesCorrectly_true() {
    Client testClient = new Client("Jill", 1, "5035550101");
    assertEquals(true, testClient instanceof Client);
  }
  @Test
  public void getId_clientInstantiateWithAnId_1() {
    Client testClient = new Client("Jill", 1, "5035550101");
    testClient.save();
    assertTrue(testClient.getId() > 0);
  }
  @Test
  public void getName_clientInstantiatesWithName_Alana() {
    Client testClient = new Client("Jill", 1, "5035550101");
    assertEquals("Jill", testClient.getName());
  }
  @Test
  public void getExtention_clientInstantiatesWithStylistId_1() {
    Client testClient = new Client("Jill", 1, "5035550101");
    testClient.save();
    assertEquals(1, testClient.getStylistId());
  }
  @Test
  public void getSpecialty_clientInstantiatesWithSpecialtPhoneNumber_5035550101() {
    Client testClient = new Client("Jill", 1, "5035550101");
    testClient.save();
    assertEquals("5035550101", testClient.getPhoneNumber());
  }

}
