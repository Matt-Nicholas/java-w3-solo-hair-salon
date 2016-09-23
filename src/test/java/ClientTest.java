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
    @Test
    public void find_returnsClientById_client2 (){
        Client client1 = new Client("Jill", 1, "5035550101");
        client1.save();
        Client client2 = new Client("Amy", 2, "5035550102");
        client2.save();
        assertEquals(Client.find(client2.getId()), client2);
    }
    @Test
    public void all_returnAllClients_true(){
        Client client1 = new Client("Jill", 1, "5035550101");
        client1.save();
        Client client2 = new Client("Amy", 2, "5035550102");
        client2.save();
        assertEquals(true, Client.all().get(0).equals(client1));
        assertEquals(true, Client.all().get(1).equals(client2));
    }
    @Test
    public void findByPhone_returnsClientByPhone_testClient (){
        Client testClient = new Client("Jill", 1, "5035550101");
        testClient.save();
        assertEquals(Client.findByPhone("5035550101"), testClient);
    }
    @Test
    public void delete_deletesClient_true() {
        Client testClient = new Client("Jill", 1, "5035550101");
        testClient.save();
        int testClientId = testClient.getId();
        testClient.delete();
        assertEquals(null, Client.find(testClientId));
    }
    @Test
    public void updateStylistId_updatesStylistIdForGivenClient_2(){
        Client testClient = new Client("Jill", 1, "5035550101");
        testClient.save();
        testClient.updateStylistId(2);
        assertEquals(2, Client.find(testClient.getId()).getStylistId());
    }
    @Test
    public void updatePhone_updatesPhoneNumberGivenClient_2(){
        Client testClient = new Client("Jill", 1, "5035550101");
        testClient.save();
        testClient.updatePhone("5035550102");
        assertEquals("5035550102", Client.find(testClient.getId()).getPhoneNumber());
    }

}
