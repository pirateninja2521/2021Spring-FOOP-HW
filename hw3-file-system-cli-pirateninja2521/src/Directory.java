import java.util.TreeSet;

public class Directory extends Node{
    private TreeSet<Node> childNodeSet;
    
    public Directory(Directory parentDir, String name){
        super(parentDir, name);
        this.childNodeSet = new TreeSet<Node>();
    }
    public static Directory newRoot() {
        Directory root = new Directory(null, null);
        root.parentDir = root;
        return root;
    }

    public Node findChildNode(String directoryName){
        for (Node childNode : childNodeSet){
            if(directoryName.equals(childNode.toString())){
                return childNode;
            }
        }
        return null;
    }

    public void addToList(Node node){
        assert(findChildNode(node.toString())==null);
        childNodeSet.add(node);
    }

    public void list() {
        for (Node childNode : childNodeSet){
            System.out.println(childNode);
        }
    }

    public void removeFromList(Node node) {
        childNodeSet.remove(node);
    }
    public void searchList(String keyword) {
        if (!isRoot() && this.toString().contains(keyword)) System.out.println(this);
        for (Node childNode : childNodeSet){
            if (childNode instanceof Directory) ((Directory)childNode).searchList(keyword);
            else if (childNode.toString().contains(keyword)) System.out.println(childNode);
            
        }
    }
}
