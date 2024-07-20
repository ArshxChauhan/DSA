public class Stack {

    private Node top;
    private int height;

    static class Node{

        int data;
        Node next;

        Node(int data){
            this.data = data;
        }

    }

    Stack(int data){
        Node newNode = new Node(data);

        top = newNode;
        height = 1;

    }

    public void push(int data){

        Node newNode = new Node(data);

        if(height==0){
            top = newNode;
        }
        else{

            newNode.next = top;
            top = newNode;

        }

        height++;

    }


    public Node pop(){

        if(height == 0){
            return null;
        }

        else{

            Node temp = top;
            top = top.next;
            temp.next = null;
            height--;

            return temp;

        }

    }

    public static void main(String[] args){

        Stack stack = new Stack(2);
        stack.push(4);
        stack.push(6);

        System.out.println("top-> " + stack.top.data);
        System.out.println("height-> " + stack.height);
    }

}
