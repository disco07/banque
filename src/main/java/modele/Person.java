package modele;

import org.bson.types.ObjectId;

import java.util.Objects;

public class Person {

    private ObjectId id;
    private String name;
    private String surname;
    private int age;
    private Address address;
    private Compte compte;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address) && Objects.equals(compte, person.compte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, address, compte);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", address=").append(address);
        sb.append(", compte=").append(compte);
        sb.append('}');
        return sb.toString();
    }

    public ObjectId getId() {
        return id;
    }

    public Person setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Person setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Person setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Compte getCompte() {
        return compte;
    }

    public Person setCompte(Compte compte) {
        this.compte = compte;
        return this;
    }
}
