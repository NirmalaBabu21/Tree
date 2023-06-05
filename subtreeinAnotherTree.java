public class subtreeinAnotherTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;    
        }
    }
    static class BinaryTree{
        static int idx=-1;
        public TreeNode binary(int nodes[]){
            idx++;
            if(nodes[idx]==-1)
            return null;
            TreeNode newNode=new TreeNode(nodes[idx]);
            newNode.left=binary(nodes);
            newNode.right=binary(nodes);
            return newNode;
        }
        public boolean isIdentical(TreeNode root, TreeNode subtree){
            if(root==null && subtree==null)
            return true;
            if(root==null || subtree==null)
            return false;
            if(root.data==subtree.data)
            return isSubtree(root.left, subtree.left) && isSubtree(root.right, subtree.right);
            return false;
        }
        public boolean isSubtree(TreeNode root, TreeNode subtree){
            if(subtree==null)
            return true;
            if(root==null)
            return false;
            if(root.data==subtree.data){
                return isIdentical(root, subtree);
            }
            return isSubtree(root.left, subtree) || isSubtree(root.right, subtree);
        }
    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int sub[]={1,2,-1,-1,3,-1,-1};
        int node1[]={9,7,8,-1,-1,1,2,-1,-1,3,-1,-1,4,5,-1,-1,-1};
        BinaryTree b=new BinaryTree();
        TreeNode subtree=b.binary(sub);
        TreeNode root=b.binary(nodes);
        TreeNode sub1=b.binary(node1);
        System.out.println("Comparison between root and subtree: "+ b.isSubtree(root, subtree));
        System.out.println("Comparison between root and sub1: "+b.isSubtree(root, sub1));
        }
}
