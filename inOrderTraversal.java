public class inOrderTraversal {
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
        public Node binarytree(int nodes[]){
            idx++;
            if(nodes[idx]==-1)
            return null;
            Node newNode=new Node(nodes[idx]);
            newNode.left=binarytree(nodes);
            newNode.right=binarytree(nodes);
            return newNode;
        }

        public void inorder(Node root){
            if(root==null)
            return ;
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree b=new BinaryTree();
        Node root=b.binarytree(nodes);
        System.out.print(root.data);
        System.out.println();
        System.out.println("In Order traversal: ");
        b.inorder(root);
    }
    
}
