public class Main {

    static class Trees{

        private Node root;

        public static class Node{

            int data;
            Node left;
            Node right;

            Node(int data){
                this.data = data;
            }

        }

       // No constructor required

        public boolean insert(int data){

            Node newNode = new Node(data);

            if(root == null){
                root = newNode;
                return true;
            }

            Node temp = root;

            while(true) {

                if (newNode.data == root.data) {
                    return false;
                }

                if (newNode.data < temp.data) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return true;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return true;
                    } else {
                        temp = temp.right;
                    }
                }

            }

        }


        public boolean contains(int data){

            if(root == null){
                return false;
            }

            Node temp = root;

            while(temp!=null){

                if(temp.data == data){
                    return true;
                }

                if(data<temp.data){
                    temp = temp.left;
                }
                else{
                    temp = temp.right;
                }

            }

            return false;

        }






        public Node getRoot(){
            return root;
        }

    }

    public static void main(String[] args) {

        Trees myTree = new Trees();

        myTree.insert(24);
        myTree.insert(22);
        myTree.insert(23);
        myTree.insert(11);
        myTree.insert(32);
        myTree.insert(46);
        myTree.insert(30);

        System.out.println(myTree.root.left.right.data);

        System.out.println("30: " + myTree.contains(30));
        System.out.println("89: " + myTree.contains(89));


        System.out.println("root: " + myTree.getRoot().data);

    }
}