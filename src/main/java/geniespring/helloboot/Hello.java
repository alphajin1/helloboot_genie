package geniespring.helloboot;

public class Hello {
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    private String name;
    private int count;

    public Hello(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
