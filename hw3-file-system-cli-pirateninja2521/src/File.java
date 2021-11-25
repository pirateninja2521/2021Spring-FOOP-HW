public class File extends Node{
    protected String content;

    public File(Directory parentDir, String name, String content) {
        super(parentDir, name);
        this.content = content;
    }

    public void printContent() {
        System.out.println(content);
    }
}
