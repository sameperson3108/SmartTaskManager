public class Task {
    private int id;
    private String name;
    private boolean complete;

    public Task(int id, String name, boolean complete) {
        this.id = id;
        this.name = name;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return id + ". " + (complete ? "[+] " : "[-] ") + name;
    }
}
