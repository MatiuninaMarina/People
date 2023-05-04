import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (age.isPresent()) {
            if (age.getAsInt() < 0) {
                throw new IllegalArgumentException("Введите значение больше нуля!");
            }
            if (name == null || surname == null) {
                throw new IllegalStateException("Укажите недостающие данные!");
            }
            Person person = new Person(name, surname, age.getAsInt());
            person.setAddress(city);
            return person;

        } else {
            if (name == null || surname == null) {
                throw new IllegalStateException("Укажите недостающие данные!");
            }
            Person person = new Person(name, surname);
            person.setAddress(city);
            return person;
        }
    }


}
