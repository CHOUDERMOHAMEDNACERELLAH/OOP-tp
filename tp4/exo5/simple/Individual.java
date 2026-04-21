package tp4.exo5.simple;

public class Individual {
    private String name;
    private String id;
    private int age;

    public Individual(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void performAction() {
        System.out.println(name + " is performing a general action.");
    }

    public String toString() {
        return "Individual [name=" + name + ", id=" + id + ", age=" + age + "]";
    }
}
