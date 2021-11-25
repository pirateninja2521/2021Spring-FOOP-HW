public class Link extends File{
    public Link(Directory parentDir, String name, String targetName) {
        super(parentDir, name, targetName);
    }
    
    public void printContent() {
        String out;
        if (parentDir.isRoot()){
            out = "/" + content;
        }
        else{
            out = parentDir.getPath() + "/" + content;
        }
        System.out.println(out);
    }

    public String resolveLink() {
        return content;
    }
}
