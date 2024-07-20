public class Queue {

    private Node first;
    private Node last;
    private int length;

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    Queue(int data){

        Node newNode = new Node(data);
        first = newNode;
        last = newNode;
        length = 1;

    }

    public void enqueue(int data){

        Node newNode = new Node(data);

        if(length == 0){
            first = newNode;
            last = newNode;
        }

        else{

            last.next = newNode;
            last = newNode;

        }

        length++;

    }

    public Node dequeue(){

        if(length == 0){
            return null;
        }

        Node temp = first;

        if(length == 1){
            first = null;
            last = null;
        }

        else{

            first = first.next;
            temp.next = null;

        }

        length--;

        return temp;

    }

    public void printQueue(){

        Node temp = first;

        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

    }

    public static void main(String[] args){

        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(15);


        queue.printQueue();


        // after dequeue

        System.out.println("\n");

        queue.dequeue();

        queue.printQueue();


    }

}
