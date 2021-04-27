package learntaskfour.binarytree;

import java.util.List;

public class BinaryTree {
    private BinaryTree left;
    private BinaryTree right;
    private int value;

    BinaryTree(int value){
        left = null;
        right = null;
        this.value = value;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }
    //прямой обход дерева, значения запиываем в лист values
    public void preOrder(List<Integer> values){
        values.add(value);

        if(left != null)
            left.preOrder(values);
        if(right != null)
            right.preOrder(values);
    }

    //обратный обход
    public void postOrder(List<Integer> values){
        if(left != null)
            left.postOrder(values);
        if(right != null)
            right.postOrder(values);

        values.add(value);
    }

    //центрированный обход
    public void inOrder(List<Integer> values){
        if(left != null)
            left.inOrder(values);

        values.add(value);

        if(right != null)
            right.inOrder(values);
    }
}
