public class Peoples {
    private final String name;
    private final int age;
    private final double height;

    public Peoples(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Peoples{" +
                "name: " + name + '\'' +
                ", age: " + age +
                ", height: " + height +
                '}';
    }
}

