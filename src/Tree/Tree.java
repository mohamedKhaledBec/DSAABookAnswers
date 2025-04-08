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


}
