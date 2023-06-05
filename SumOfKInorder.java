public class SumOfKInorder 
    {
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
    
            public int  sum(Node root, int k){
                if(root==null)
                return 0;
                if (k==1)
                return root.data;
                int leftSum=sum(root.left,k-1);
                int rightSum= sum(root.right,k-1);
                return leftSum+rightSum;
            }
        }
        public static void main(String args[]){
            int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            BinaryTree b=new BinaryTree();
            Node root=b.binarytree(nodes);
            System.out.println("Sum of Kth Level using In Order traversal: ");
            System.out.println(b.sum(root,2));
        }
        
    }
        

