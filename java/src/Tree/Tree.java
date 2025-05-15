package Tree;

import List.Node;

public class Tree {

    protected TreeNode root;

    public Tree(){
        root = null;
    }

    public TreeNode getRoot(){
        return root;
    }

    public void setRoot(TreeNode root){
        this.root = root;
    }

    protected void insertChild(TreeNode parent, TreeNode child){
        if (parent == null) {
            root = child;
        } else {
            if (child.data < parent.data) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
    }

    public void iterativeInsert(TreeNode node){
        TreeNode parent = null;
        TreeNode tmp = root;
        while (tmp != null) {
            parent = tmp;
            if (node.getData() < tmp.getData()){
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        insertChild(parent, node);
    }

    public void prettyPrint(){
        if (root != null){
            root.prettyPrint(0);
        }
    }


    //Q25
    boolean isMirror (TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        boolean ismirrored = (left.data == right.data) & (isMirror(left.left, right.right)) & (isMirror(left.right, right.left));
        return ismirrored;
    }
    //Q24
    int product() {

            TreeNode tmp;
            int Product = 1;
            Stack c = new Stack(100);
            if (root != null){
                c.push(new Element(root));
            }
            while (!c.isEmpty()){
                Element e = c.pop();
                tmp = e.getData();
                Product *= tmp.data;
                if (tmp.getLeft() != null){
                    c.push(new Element(tmp.getLeft()));
                }
                if (tmp.getRight() != null){
                    c.push(new Element(tmp.getRight()));
                }
            }
            return Product;
    }
    boolean isIdentical(TreeNode T1, TreeNode T2) {
        if(T1 == null && T2 == null){return true;}
        if(T1 == null || T2 == null){return false;}
        if(T1.data!=T2.data){return false;}
        return isIdentical(T1.left, T2.left) && isIdentical(T1.right, T2.right);
    }
    int product1(){
        Stack stack = new Stack(100);
        int product = 1;
        stack.push(new Element(root));
        while (!stack.isEmpty()) {
            TreeNode e = stack.pop().getData();
            product *= e.data;
            if (e.right != null) stack.push(new Element(e.right));
            if (e.left != null) stack.push(new Element(e.left));

        }
        return product;
    }

}
