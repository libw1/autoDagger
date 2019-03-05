package conykais.autodaggerdemo;

public class Mode {

    private String name;
    private Person person;

    public Mode(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Mode{" +
                "name='" + name + '\'' +
                ", person id=" + person.getId() +
                ", person name =" + person.getName() +
                '}';
    }
}
