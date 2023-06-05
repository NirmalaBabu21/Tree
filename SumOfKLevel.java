import java.util.*;
public class SumOfKLevel {
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
        public int Sum(TreeNode root,int k){
            if (root == null)
        return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        int sum = 0;
        int flag = 0;
        while (!que.isEmpty()){
        int size = que.size();
        while (size>0){
            TreeNode ptr = que.peek();
            que.remove();
            if (level == k)
            {flag = 1;
             sum += ptr.data;
            }
            else {
                if (ptr.left != null)
                    que.add(ptr.left);
                if (ptr.right != null)
                    que.add(ptr.right);
            }
            size--;
        }
        level++;
        if (flag == 1)
            break;
        }
        return sum;
        }

    }
    public static void main(String args[]){
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree b=new BinaryTree();
        TreeNode root=b.binary(nodes);
        System.out.println("Sum of kth level using Level Order traversal: ");
        System.out.println(b.Sum(root,3));
    }
    
}
