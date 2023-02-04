import java.util.OptionalInt;

public class PersonBuilder {

    protected String name;
    protected String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 150 || age < 0) throw new IllegalArgumentException("Wrong age!");
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    private Person getPerson() {
        if (!age.isPresent())
            return new Person(name, surname);
        else
            return new Person(name, surname, age.getAsInt());
    }

    public Person build() {
        if (name == null || surname == null)
            throw new IllegalStateException("Person can't be without name or surname!");
        Person person = getPerson();
        person.setAddress(this.address);
        return person;
    }
}