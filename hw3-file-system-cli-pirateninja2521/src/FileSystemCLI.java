import static utils.Inputs.in;

public class FileSystemCLI {
    private static final Exception exception = null;
    private Directory currentDir;

    public void start() {
        currentDir = Directory.newRoot();
        while (true) {
            printCurrentPath();
            String command = in.nextLine();
            if (command.equals("exit")) {
                break;
            }
            executeCommand(command);
        }
    }

    private void printCurrentPath() {
        System.out.println("Current path: " + currentDir.getPath());
    }

    public void executeCommand(String command) {
        String[] segments = command.split("\\s");

        try {
            String commandName = segments[0];
            performCommand(commandName, segments);   
        } catch (Exception err) {
            // System.err.println("(Debug) Error: " + err.getMessage());
            System.out.println("Illegal command.");
        }
    }

    private void performCommand(String commandName, String[] segments) throws Exception{
        try{
            switch (commandName) {
                case "cd":
                    changeDirectory(segments[1]);
                    break;
                case "mkdir":
                    makeDirectory(segments[1]);
                    break;
                case "touch":
                    touch(segments[1], segments[2]);
                    break;
                case "rm":
                    remove(segments[1]);
                    break;
                case "cat":
                    concatenate(segments[1]);
                    break;
                case "ls":
                    list();
                    break;
                case "search":
                    search(segments[1]);
                    break;
                case "ln":
                    link(segments[1], segments[2]);
                    break;
            }
        }catch(Exception exception){
            throw exception;
        }
    }

    private void changeDirectory(String directoryName) throws Exception{
        if (directoryName.equals("..")) {
            currentDir = currentDir.getParent();
            return;
        }
        Node newNode = currentDir.findChildNode(directoryName);
        if (newNode == null) throw exception;
        if (newNode instanceof Directory) currentDir = (Directory) newNode;
        else if (newNode instanceof Link) changeDirectory(((Link) newNode).resolveLink());
        else throw exception;
    }

    private void makeDirectory(String directoryName) throws Exception{
        if (currentDir.findChildNode(directoryName) != null) throw exception;
        currentDir.addToList(new Directory(currentDir, directoryName));
    }

    private void touch(String fileName, String content) throws Exception{
        if (currentDir.findChildNode(fileName) != null) throw exception;
        currentDir.addToList(new File(currentDir, fileName, content));
    }

    private void remove(String childName) throws Exception{
        Node newNode = currentDir.findChildNode(childName);
        if (newNode == null) throw exception;
        newNode.getParent().removeFromList(newNode);
    }

    private void concatenate(String fileName) throws Exception{
        Node newNode = currentDir.findChildNode(fileName);
        if (newNode == null || newNode instanceof Directory) throw exception;
        ((File) newNode).printContent();
    }

    private void list(){
        currentDir.list();
    }

    private void link(String targetName, String linkName) throws Exception{
        Node dirNode = currentDir.findChildNode(targetName);
        if (dirNode == null || !(dirNode instanceof Directory) || currentDir.findChildNode(linkName) != null) throw exception;
        currentDir.addToList(new Link(currentDir, linkName, dirNode.toString()));
    }

    private void search(String keyword) {
        currentDir.searchList(keyword);
    }

}
