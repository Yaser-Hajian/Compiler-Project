package Utils.command;

public class DataLine {
    private String name;
    private String directive;
    private String value;

    public DataLine(String name, String directive, String value) {
        this.name = name;
        this.directive = directive;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ": ." + directive + " " + value;
    }
}