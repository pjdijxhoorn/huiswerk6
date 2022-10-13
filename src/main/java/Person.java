import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middlename;
    private String lastname;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children= new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();
    private List<Person> grandchildren = new ArrayList<>();


    //                  -----Constructors-----
    public Person(String name, String lastname, String sex, int age) {
        this.name = name;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String middlename, String lastname, String sex, int age) {
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
        this.sex = sex;
        this.age = age;
    }
    //                  -----getters setters-----

    public List<Person> getGrandchildren() {
        return grandchildren;
    }

    public void setGrandchildren(List<Person> grandchildren) {
        this.grandchildren = grandchildren;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


    //                  -----methodes-----
    public void addParents(Person father, Person mother, Person child) {
        child.setMother(mother);
        child.setFather(father);
        addChild(mother, child);
        addChild(father, child);
    }

    public void addChild(Person parent, Person child) {
        parent.getChildren().add(child);
    }

    public void getGrandChildren(Person Grootouder, List<Person> children) {
        for (Person child : children) {
            System.out.println("kind van "+ Grootouder.getName() + " is: "+ child.getName());
            for (int i = 0; i < child.getChildren().size(); i++) {
                System.out.println(child.getChildren().get(i).getName());
                Grootouder.getGrandchildren().add(child.getChildren().get(i));
            }
        }
    }
    public void addPet (Person owner, Pet pet){
        owner.pets.add(pet);
    }
    public void addSibling(Person sibling1, Person sibling2){
        sibling1.getSiblings().add(sibling2);
        sibling2.getSiblings().add(sibling1);
    }
}



