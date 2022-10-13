import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {


    @Test
    void shouldAddParents() {
        //              -----ARRANGE----->> OBJECT
        Person mother = new Person("Ilse", "van der", "Kamp", "Female", 23);
        Person father = new Person("Bas", "van der", "Kamp", "Male", 23);
        Person child = new Person("Marije", "van der Kamp", "Female", 28);

        //              -----ACT----->> welke methodes test je?
        child.addParents(father,mother,child);

        //              -----ASSERT----->> welke uitkomst verwacht je
        assertEquals("Ilse",child.getMother().getName());
        assertEquals("Bas",child.getFather().getName());
        assertEquals("Marije",father.getChildren().get(0).getName());
        assertEquals("Marije",mother.getChildren().get(0).getName());

    }

    @Test
    void shouldaddChild() {
        //              -----ARRANGE----->> OBJECT
        Person parent = new Person("Bas", "van der", "Kamp", "Male", 23);
        Person child = new Person("Marije", "van der Kamp", "Female", 28);
        List<Person> children = new ArrayList<>();

        //              -----ACT----->> welke methodes test je?
        parent.addChild(parent, child);


        //              -----ASSERT----->> welke uitkomst verwacht je
        assertEquals("Bas", parent.getName());
        assertEquals("Marije", parent.getChildren().get(0).getName());
        assertEquals("van der Kamp", parent.getChildren().get(0).getLastname());
        assertNotNull(children);
    }

    @Test
    void shouldgetGrandChildren() {
        //              -----ARRANGE----->> OBJECT
        Person grootvader = new Person("grootvader", "dijxkie","male", 67);
        Person grootmoeder = new Person("grootmoeder", "dijxkie","female", 67);

        Person vader = new Person("vader", "dijxkie","male", 67);
        Person moeder = new Person("moeder", "wiersma","female", 67);

        Person vader2 = new Person("vader2", "dijxkie","male", 67);
        Person moeder2 = new Person("moeder2", "Den Boer","female", 67);

        Person kind1 = new Person("kind 1", "dijxkie","male", 67);
        Person kind2  = new Person("kind 2", "dijxkie","female", 67);
        Person kind3 = new Person("kind 3", "dijxkie","male", 67);
        Person kind4  = new Person("kind 4", "dijxkie","female", 67);

        grootvader.addParents(grootvader,grootmoeder,vader);
        grootvader.addParents(grootvader,grootmoeder,vader2);

        vader.addParents(vader,moeder,kind1);
        vader.addParents(vader,moeder,kind2);

        vader2.addParents(vader2,moeder2,kind3);
        vader2.addParents(vader2,moeder2,kind4);

        //              -----ACT----->> welke methodes test je?
        grootvader.getGrandChildren(grootvader,grootvader.getChildren());

        //              -----ASSERT----->> welke uitkomst verwacht je
        assertEquals("kind 1",grootvader.getGrandchildren().get(0).getName());
        assertEquals("kind 2",grootvader.getGrandchildren().get(1).getName());
        assertEquals("kind 3",grootvader.getGrandchildren().get(2).getName());
        assertEquals("kind 4",grootvader.getGrandchildren().get(3).getName());

    }

    @Test
    void shouldaddPet() {
        //              -----ARRANGE----->> OBJECT
        Person owner = new Person("Bas", "van der", "Kamp", "Male", 23);
        Pet evi = new Pet("evi",12,"hond");

        //              -----ACT----->> welke methodes test je?
        owner.addPet(owner,evi);

        //              -----ASSERT----->> welke uitkomst verwacht je
        assertEquals("evi",owner.getPets().get(0).getName());
    }

    @Test
    void shouldaddSibling() {
        //              -----ARRANGE----->> OBJECT
        Person brother = new Person("Bas", "van der", "Kamp", "Male", 23);
        Person sister = new Person("Marije", "van der Kamp", "Female", 28);

        //              -----ACT----->> welke methodes test je?
        brother.addSibling(brother,sister);

        //              -----ASSERT----->> welke uitkomst verwacht je
        assertEquals("Bas",sister.getSiblings().get(0).getName());
        assertEquals("Marije",brother.getSiblings().get(0).getName());

    }



    /*
    Naast de @Test annotaties maakt JUnit gebruik van de volgende annotaties:

    *   @Test : Geeft aan dat de methode een unit-test is.
    *   @BeforeAll : Deze methode wordt eenmalig uitgevoerd voordat alle unit-test-methodes worden gedraaid.
        Een database connectie wordt vaak in deze annotatie opgezet.
    *   @BeforeEach : Deze methode wordt voor elke unit test opnieuw uitgevoerd.
        Bijvoorbeeld een object dat voor elke unit-test opnieuw moet worden aangemaakt.
    *   @AfterAll : Deze methode wordt eenmalig uitgevoerd nadat alle unit-test-methodes zijn gedraaid.
        Het beëindigen van de databaseconnectie gebeurt vaak in deze methode.
    *   @AfterEach : Deze methode wordt na elke unit test opnieuw uitgevoerd.
        Bijvoorbeeld het herstellen van de standaardwaardes van een object.
    *   @Disabled : Met deze annotatie geef je aan dat een test uit staat.
        Zet een test nooit uit, omdat die faalt!
        Zorg ervoor dat @Disabled unit-testen un-@Disabled voordat je jouw code deelt met collega'.

    Je hebt geleerd dat je unit-testen altijd een true of een false moeten testen.
    Hierdoor voorkom je dat een resultaat op meerdere manieren te interpreteren is.
    JUnit heeft handvaten in de vorm van Assertions. De Assertions zijn:

    *   assertEquals: Wanneer de equals()-methode is overriden, wordt deze gebruikt.
        Anders wordt de referentie (het geheugenadres) tussen de twee objecten vergeleken.
    *   assertSame: Vergelijkt het referentie adres (het geheugenadres) tussen de twee objecten.
    *   assertNotSame: Tegenovergestelde van assertSame().
    *   assertTrue: Controleert of de uitkomst overeenkomt met true
    *   assertFalse: Controleert of de uitkomst overeenkomt met false
    *   assertArrayEquals:
    *   assertNull: Bekijkt of het gegeven object null is.
    *   assertNotNull: Tegenovergestelde van assertNotNull.
    *   fail: Laat een test falen met een gegeven bericht. fail("Test not finished")*/
}