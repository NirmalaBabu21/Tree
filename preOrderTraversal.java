public class preOrderTraversal{
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
        public void preorder(Node root){
            if(root==null){
                //System.out.print("-1 ");
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binary b=new Binary();
        Node root=b.binaryTree(nodes);
        System.out.print(root.data);
        System.out.println();
        System.out.println("Pre order traversal:");
        b.preorder(root);
    }
}