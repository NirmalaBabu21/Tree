import java.util.*;
public class LevelOrderTraversal {
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
        public void levelOrder(Node root){
            if(root==null)
            return;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty())
                    break;
                    else
                    q.add(null);
                }
                else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null)
                        q.add(currNode.left);
                    if(currNode.right!=null)
                        q.add(currNode.right);
                     }
                     }

        }
    }

    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree b=new BinaryTree();
        Node root=b.binary(nodes);
        System.out.print(root.data);
        System.out.println();
        System.out.println("Level Order traversal: ");
        b.levelOrder(root);
    }
}
