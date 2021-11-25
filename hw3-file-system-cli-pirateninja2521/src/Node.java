public abstract class Node implements Comparable<Node>{
    protected Directory parentDir;
    protected String name;

    public Node(Directory parentDir, String name){
        this.parentDir = parentDir;
        this.name = name;
    }

    public Directory getParent() {
        return parentDir;
    }

    public Boolean isRoot(){
        return this == this.parentDir;
    }
    public String getPath(){
        if (isRoot()) return "/";
        else if (parentDir.isRoot()){
            return "/" + name;
        }
        else{
            return parentDir.getPath() + "/" + name;
        }
    }

    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public int compareTo(Node node) {
        return this.name.compareTo(node.name);
    }

}
