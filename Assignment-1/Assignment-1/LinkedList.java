 /**
  * @author : saitejasedate.
  */
 /**
  * List of linkeds.
  */
 class LinkedList {
    private int size;
    public Node start;
    LinkedList() {
        this.size = 0;
        this.start = null;
    }
    /**
     * size of the linked list.
     *
     * @return     { return size }.
     */
    public int size() {
        return size;
    }
    /**
     * Pushes a right.
     *
     * @param      data  The data
     */
    public void pushRight(int data) {
        if (start == null) {
            Node newNode = new Node(data);
            start = newNode;
        }
        else {
            Node temp = start;
            Node newNode = new Node(data);
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        size++;
    }
    /**
     * Pushes a left.
     *
     * @param      data  The data
     */
    public void pushLeft(int data) {
        Node newnode = new Node(data);
        newnode.setNext(start);
        start = newnode;
        size++;
    }
    /**
     * Removes a left.
     */
    public void removeLeft() {
        if (start != null) {
            start = start.getNext();
            size--;
        } else {
            System.out.println("No nodes to remove");
        }
    }
    /**
     * Removes the given data from linked list.
     *
     * @param      data  The data
     */
    public void remove(int data) {
        Node temp1 = start;
        if(temp1.getData() == data) {
            temp1 = temp1.getNext();
            start = temp1;
        } else {
            while(temp1.getNext().getNext()!= null) {
                if(temp1.getNext().getData() == data) {
                    break;
                }
                temp1 = temp1.getNext();
            }
            if(temp1.getNext().getData() == data) {
                temp1.setNext(temp1.getNext().getNext());
            }
        }
        size--;
    }
    /**
     * removes the left node and updates the new start.
     */
    public void popLeft() {
        if (start != null) {
            start = start.getNext();
            size--;
        } else {
            System.out.println("No nodes to remove");
        }
    }
    // public Node getHead() {
    //     return start;
    // }
    /**
     * Removes a right.
     */
    public void removeRight() {
        if (start == null) {
            System.out.println("No nodes to remove");
        } else if (size < 2) {
            start = null;
            size--;
        } else {
            Node temp = start;
            while (temp.getNext().getNext() !=null) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            size--;
        }
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        Node temp = start;
        if (temp == null) {
            return "Empty linked list";
        }
        while (temp.getNext() != null) {
            s += temp.getData() + ", ";
            temp = temp.getNext();
        }
        s += temp.getData();
        return s;
    }
}
