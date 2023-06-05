public class BinaryTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Binary{
        static int idx=-1;

        public Node binaryTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=binaryTree(nodes);
            newNode.right=binaryTree(nodes);
            return newNode;
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary b=new Binary();
        Node root=b.binaryTree(nodes);
        System.out.print(root.data);
    }
}