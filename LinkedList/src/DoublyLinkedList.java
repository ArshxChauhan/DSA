public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    static class Node{

        int value;
        Node prev;
        Node next;

        Node(int value){
            this.value = value;
        }

    }


    // constructor
    DoublyLinkedList(int data){

        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;

    }


    //append method
    public void append(int data){


        Node newNode = new Node(data);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }

        else{

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;

        }

        length++;

    }

    // removeLast

    public Node removeLast(){

        if(length == 0){
            return null;
        }

        Node temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;

        }
        length--;

        return temp;

    }

    public void prepend(int data){

        Node newNode = new Node(data);

        if(length == 0){
            head = newNode;
            tail = newNode;
        }

        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        length++;
    }

    public Node removeFirst(){

        if(length == 0){
            return null;
        }

        Node temp = head;

        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;

    }

    public Node get(int index){

        if(index < 0 || index >= length){
            return null;
        }

        Node temp;

        if(index < length/2){
            temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }

        }

        else{
            temp = tail;
            for(int i=length-1;i>index;i--){
                temp = temp.prev;
            }
        }

        return temp;

    }

    public boolean set(int index, int value){

        Node temp = get(index);

        if(temp!=null){
            temp.value = value;
            return true;
        }

        return false;

    }


    public boolean insert(int index, int value){

        if(index < 0 || index >length){
            return false;
        }

        if(index == 0){
            prepend(value);
            return true;
        }

        if(index == length){
            return true;
        }

        Node newNode = new Node(value);

        Node pre = get(index-1);

        pre.next.prev = newNode;
        pre.next = newNode;
        length++;
        return true;



    }


    public Node remove(int index){

        if(index < 0 || index >= length){
            return null;
        }

        if(index == 0){
            return removeFirst();
        }

        if(index == length-1){
            return removeLast();
        }

        Node temp = get(index);

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = null;
        temp.prev = null;
        length--;

        return temp;

    }


    //print method
    public void printDLL(){

        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }

    }


    public static void main(String[] args){

        DoublyLinkedList myDLL = new DoublyLinkedList(2);

        myDLL.append(3);
        myDLL.append(4);

        System.out.println(myDLL.get(2).value);



        myDLL.printDLL();

    }

}
