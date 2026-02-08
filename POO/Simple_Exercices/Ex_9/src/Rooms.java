public class Rooms {
    private String name;
    private String email;
    private boolean isEmpty;

    public Rooms(String name, String email, boolean isEmpty) {
        this.name = name;
        this.email = email;
        this.isEmpty = isEmpty;
    }
    @Override
    public String toString() {
        return "Rooms{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
