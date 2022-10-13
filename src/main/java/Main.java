public class Main {

    public static void main(String[] args) {
        // sorry had wat moeite met github koppelen en heb daardoor per ongeluk alles te vroeg gepushd naar de main branch.
        System.out.println("Hello Maven");

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
        kind1.addSibling(kind1,kind2);

        vader2.addParents(vader2,moeder2,kind3);
        vader2.addParents(vader2,moeder2,kind4);
        kind3.addSibling(kind3,kind4);


        grootvader.getGrandChildren(grootvader, grootvader.getChildren());
        vader.getGrandChildren(vader, vader.getChildren());

        Pet evi = new Pet("evi",12,"hond");
        kind1.addPet(kind1,evi);
        evi.addOwner(evi,kind1);

        System.out.println();

        System.out.println(grootvader.getGrandchildren().get(0).getName());




    }
}
