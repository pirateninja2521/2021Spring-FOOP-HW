# Design Report
> Please follow the instructions in homework 3 (officially announced version on NTU COOL) to finish the report.

## Software Design

### class Main
Not modified

### class FileSystemCLI
I used the skeleton code provided by TA and simply implement the methods called by method *performCommand* (*changeDirectory*, *findChildNode*, etc). 

### abstract class Node
Super class of *File,  Directory*. Implements methods that are used by all sub classes (e.g. *getPath*). 

### class Directory
Sub class of *Node*. Uses a variable Treeset *childNodeList* to store its child nodes (maintained by methods *addToList, removeFromList*). Has method *findChildNode, searchList*,... that are used by the methods in FileSystemCLI. 

### class File
Sub class of *Node*, super class of *Link*. Has variable *content* and method *printContent* which are used by *concatenate* method in FileSystemCLI. 

### class Link
Sub class of *Link*. Has method *resolveLink* which is used by *concatenate* and *changeDirectory* method of FileSystemCLI, and overrides method *printContent* of *Node* . 
