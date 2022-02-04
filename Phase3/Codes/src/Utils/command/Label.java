package Utils.command;

public class Label {
    String name;
    public Label(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ":";
    }
}