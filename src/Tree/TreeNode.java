package Tree;

import List.LinkedList;
import List.Node;

public class TreeNode {

    protected TreeNode left;
    protected TreeNode right;
    protected int data;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft(){
        return left;
    }

    public TreeNode getRight(){
        return right;
    }

    public int getData(){
        return data;
    }

    public void setLeft(TreeNode left){
        this.left = left;
    }

    public void setRight(TreeNode right){
        this.right = right;
    }

    public void prettyPrint(int level){
        for (int i = 0; i < level; i++){
            System.out.print("\t");
        }
        System.out.println(data);
        if (left != null){
            left.prettyPrint(level + 1);
        }
        if (right != null){
            right.prettyPrint(level + 1);
        }
    }
    //Q17
    void accumulateLeafNodes(Queue queue){
        if(left != null){
            left.accumulateLeafNodes(queue);
        }
        if(left == null && right == null){// NOTE: this is the inorder traversing. Here you need to check if it is a leaf before adding. Allways add the logic here for inorder
            queue.enqueue(new Element(this));
        }

        if(right != null){
            right.accumulateLeafNodes(queue);
        }
    }
    //Q9
    int HigherThanX (int x){//*
        int count = 0;
        //first i check if i have to check on both sides or right only is enough by the outer if cases
        if (data>x){//both
            count=1;
            if(left != null){
                count += left.HigherThanX(x);
            }
            if(right != null){
                count += right.HigherThanX(x);
            }

        }
        else{//only right side search
            if(right!=null){
                count += right.HigherThanX(x);
            }
        }
        return count;
    }
    //Q20
    int sumOfNodesBetween (int p , int q){
        int sum=0;
        if(data<p){
            if(right != null){
                sum = sumOfNodesBetween(p, q);
            }
        }
        else if (data>q){
            if(left != null){
                sum = sumOfNodesBetween(p, q);
            }
        }
        else if(data<q && data>p){
            sum=data;//Don't forget to assign The counter or product or sum here.
            if(left != null){
                sum+=left.sumOfNodesBetween(p, q);
            }
            if(right != null){
                sum+=right.sumOfNodesBetween(p, q);
            }
        }
        return sum;
    }
    //Q13
    void pathList (LinkedList l){
        l.insertFirst(new Node(data));
        if (data % 2 == 0) {
            if ( right != null ) {
                right.pathList(l);
            }
        }
        else {
            if ( left != null ) {
                left.pathList(l);
            }
        }
    }
    //Q6
    int numberOfNonLeafNodes(){
        int count = 0;
        if(left !=null || right!=null){
            count=1;
        }
        if(right!=null){

            count+=right.numberOfNonLeafNodes();
        }
        if(left!=null){

            count+=left.numberOfNonLeafNodes();
        }
        return count;
    }
    //Q1
    int leftistOrRightist(){
        int count=0;

        if(right!=null&&left==null){
            count--;
        }
        if(left!=null&&right==null){
            count++;
        }
        if(left!=null){
            count+=left.leftistOrRightist();
        }
        if(right!=null){
            count+=right.left.numberOfNonLeafNodes();
        }
        return count;
    }

    //Q2
    int numberOfMeanNodes(){
        int count = 0;
        if(right!=null&&left!=null){
            if(data==(int)(right.data+left.data)/2){
                count=1;
            }
        }
        if(right!=null){
            count+=right.numberOfMeanNodes();
        }
        if(left!=null){
            count+=left.numberOfMeanNodes();
        }
        return count;
    }
    //Q3
    int numberofLonelyNodes(){
        int count = 0;
        if(right!=null){
            count+=right.numberofLonelyNodes();
        }
        if(left!=null){
            count+=left.numberofLonelyNodes();
        }
        if(right!=null&&left==null){
            count++;
        }
        if(left!=null&&right==null){
            count++;
        }
        return count;
    }
    //Q4
    int numberOfFullNodes(){
        int count = 0;
        if(right!=null){
            count+=right.numberOfFullNodes();
        }
        if(left!=null){
            count+=left.numberOfFullNodes();
        }
        if(right!=null&&left!=null){
            count++;
        }

        return count;
    }
    //Q7
    int numberOfleaveNodes(){
        int count = 0;
        if(right!=null){
            count+=right.numberOfleaveNodes();
        }
        if(left!=null){
            count+=left.numberOfleaveNodes();
        }
        if(right==null&&left==null){
            count++;
        }
        return count;
    }
    //Q8
    int sumofLeaves(){
        int sum=0;
        if(left!=null){
            sum+=left.sumofLeaves();
        }
        if(right!=null){
            sum+=right.sumofLeaves();
        }
        if(left==null&&right==null){
            sum+=data;
        }
        return sum;
    }
    //Q9
    int higherThanX(int x){
        int count =0;
        if(data>x){
            count=1;
            if(left != null){
                count += left.HigherThanX(x);
            }
            if(right != null){
                count += right.HigherThanX(x);
            }
        }
        else{
            if(right!=null){
                count += right.HigherThanX(x);
            }
        }

        return count;
    }
}
