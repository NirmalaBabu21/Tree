public class DiameterOptiApproch {
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
    }
    
        static class TreeInfo{
            int ht;
            int diam;
            TreeInfo(int ht,int diam){
                this.ht=ht;
                this.diam=diam;
            }
        }
        static TreeInfo diameter(Node root) {
            if(root == null) {
                return new TreeInfo(0, 0);
            }
     
            TreeInfo leftTI = diameter(root.left);
            TreeInfo rightTI = diameter(root.right);
     
            int myHeight = Math.max(leftTI.ht, rightTI.ht) + 1;
     
            int diam1 = leftTI.ht + rightTI.ht + 1;
            int diam2 = leftTI.diam;
            int diam3 = rightTI.diam;
    
            int myDiam = Math.max(diam1, Math.max(diam2, diam3));
            return new TreeInfo(myHeight, myDiam);
        }
        

        public static void main(String args[]){
            int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; 
            BinaryTree b=new BinaryTree();
            Node r=b.binary(nodes);
            System.out.println(r.data);
            System.out.println("Diamete of the given tree: "+diameter(r).diam);
            System.out.println("Height of the given tree: "+diameter(r).ht);
            
        }
        
}
