import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void stylist_instantiatesCorrectly_true() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        assertEquals(true, testStylist instanceof Stylist);
    }
    @Test
    public void getId_stylistInstantiateWithAnId_1() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        assertTrue(testStylist.getId() > 0);
    }
    @Test
    public void getName_stylistInstantiatesWithName_Alana() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        assertEquals("Alana", testStylist.getName());
    }
    @Test
    public void getExtention_stylistInstantiatesWithExtention_1() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        assertEquals(1, testStylist.getExtention());
    }
    @Test
    public void getSpecialty_stylistInstantiatesWithSpecialty_1() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        assertEquals("Colorist", testStylist.getSpecialty());
    }
    @Test
    public void getBio_stylistInstantiatesWithBio_Info() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        assertEquals("Info goes here", testStylist.getBio());
    }
    @Test
    public void getImage_stylistInstantiatesWithImageSource_Info() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        assertEquals("images/test.jpg", testStylist.getImage());
    }

    @Test
    public void find_returnsStylitsById_stylist2 (){
        Stylist stylist1 = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        stylist1.save();
        Stylist stylist2 = new Stylist("Sarah", 2, "Hairdesigner", "Info goes here", "images/test.jpg");
        stylist2.save();
        assertEquals(Stylist.find(stylist2.getId()), stylist2);
    }
    @Test
    public void findByName_returnsStylistByName_testStylist (){
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        assertEquals(Stylist.findByName("Alana"), testStylist);
    }

    @Test
    public void all_returnAllStylists_true(){
        Stylist firstStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        firstStylist.save();
        Stylist secondStylist = new Stylist("Sarah", 2, "Designer", "Info goes here", "images/test.jpg");
        secondStylist.save();
        assertEquals(true, Stylist.all().get(0).equals(firstStylist));
        assertEquals(true, Stylist.all().get(1).equals(secondStylist));
    }
    @Test
    public void updateExtention_updatesExtention_2(){
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        testStylist.updateExtention(2);
        assertEquals(2, Stylist.find(testStylist.getId()).getExtention());
    }
    @Test
    public void updateSpecialty_updatesSpecialty_Hairdesigner(){
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        testStylist.updateSpecialty("Hairdesigner");
        assertEquals("Hairdesigner", Stylist.find(testStylist.getId()).getSpecialty());
    }
    @Test
    public void updateBio_updatesBio_Updated_Info(){
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        testStylist.updateBio("Updated info");
        assertEquals("Updated info", Stylist.find(testStylist.getId()).getBio());
    }
    @Test
    public void delete_deletesStylist_true() {
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        int testStylistId = testStylist.getId();
        testStylist.delete();
        assertEquals(null, Stylist.find(testStylistId));
    }
    @Test
    public void getClients_retrievesAllClientsForStylist_clientList(){
        Stylist testStylist = new Stylist("Alana", 1, "Colorist", "Info goes here", "images/test.jpg");
        testStylist.save();
        Client firstClient = new Client("Jill", testStylist.getId(), "5035550101");
        firstClient.save();
        Client secondClient = new Client("Amy", testStylist.getId(), "5035550102");
        secondClient.save();
        Client[] clients = new Client[] {firstClient, secondClient};
        assertTrue(testStylist.getClients().containsAll(Arrays.asList(clients)));
    }

}
