public class SumOfNodes {
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
    static class BinaryTree{
        static int idx=-1;
        public Node binary(int nodes[]){
            idx++;
            if(nodes[idx]==-1)
            return null;
            Node newNode=new Node(nodes[idx]);
            newNode.left=binary(nodes);
            newNode.right=binary(nodes);
            return newNode;
        }
    static int sum(Node root){
        if(root==null)
        return 0;
        int left=sum(root.left);
        int right=sum(root.right);
        return left+right+root.data;
    }
    }

public static void main(String args[]){
    int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    BinaryTree b=new BinaryTree();
    Node root=b.binary(nodes);
    System.out.print(root.data);
    System.out.println();
    System.out.println("Sum of Nodes: ");
    System.out.println(b.sum(root));
}
}
