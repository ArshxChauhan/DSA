public class Main {



    static class LinkedList{

        private Node head;
        private Node tail;
        private int length;


        static class Node{
            int value;
            Node next;

            Node(int data){
                this.value = data;
            }
        }
//
        LinkedList(int value){
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }

        public void append(int value){

            Node newNode = new Node(value);

            if(length==0){
                head = newNode;
                tail = newNode;
            }

            else {
                tail.next = newNode;
                tail = newNode;
            }

            length++;


        }

        public Node removeLast(){

            if(length == 0){
                return null;
            }

            Node pre = head;
            Node temp = head;

            while(temp.next!=null){
                pre = temp;
                temp = temp.next;
            }

            tail = pre;
            tail.next = null;

            length--;

            if(length==0){
                head = null;
                tail = null;
            }

            return temp;


        }


        public void prepend(int data){

            Node newNode = new Node(data);

            if(length==0){

                head = newNode;
                tail = newNode;

            }

            else {

                newNode.next = head;
                head = newNode;
            }
            length++;

        }

        public Node removeFirst(){

            if(length==0){
                return null;
            }

            Node temp = head;
            head = temp.next;
            temp.next = null;

            length--;

            if(length == 0){    // Good point to remember
                tail = null;
            }

            return temp;

        }


        public Node get(int index){

            if(index < 0 || index >=length){
                return null;
            }

            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
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


        public boolean insert(int index,int value){

            if(index < 0 || index > length){
                return false;
            }

            if(index == 0){
                prepend(value);
                return true;
            }

            if(index == length){
                append(value);
                return true;
            }

            Node newNode = new Node(value);
            Node temp = get(index-1);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
            return true;


//            Node pre = head;
//            Node temp = head;
//
//            int count = 0;
//
//            while(count!=index){
//                pre = temp;
//                temp = temp.next;
//                count++;
//            }
//
//            Node newNode = new Node(value);
//
//            newNode.next = temp;
//            pre.next = newNode;
//
//            return true;



        }

        public Node remove(int index){

            if(index < 0 || index>=length){
                return null;
            }

            if(index==0){
                removeFirst();
            }

            if(index == length-1){
                removeLast();
            }

            Node temp = get(index);
            Node pre = get(index-1);

            pre.next = temp.next;
            temp.next = null;
            length--;
            return temp;

        }


        public void reverse(){

            Node before = null;
            Node temp = head;
            Node after = head;

            tail = head;

            while(temp!=null){

                after = temp.next;
                temp.next = before;
                before = temp;
                temp = after;

            }

            head = before;

        }



        // for printing the list

        public void printList(){
            Node temp = head;

            while(temp!=null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }

            System.out.println("\n");

            System.out.println("head = " + head.value);
            System.out.println("tail = " + tail.value);

            System.out.println("\nLength of the list = " + length);

        }

    }


    public static void main(String[] args) {

        LinkedList myLL = new LinkedList(2);

        myLL.append(3);
        myLL.append(4);
        myLL.append(6);

//        myLL.removeLast();

//        myLL.removeFirst();

        myLL.set(2,5);
        myLL.set(3,99);

        myLL.insert(2,4);

        myLL.remove(2);

        myLL.reverse();

        myLL.printList();


    }
}