package learntaskfour.binarytree;

import java.util.LinkedList;
import java.util.List;
/*
Создаем дерево
            1
     2            7
  3     4       8   9
      5   6

      т.е. при прямом обходе должны получить 1 2... 9
      при обратном 3 5 6 4 2 8 9 7 1
      при центрированном 3 2 5 4 6 1 8 7 9
 */
public class TreeTest {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);

        root.setLeft(new BinaryTree(2));
        root.getLeft().setLeft(new BinaryTree(3));
        root.getLeft().setRight(new BinaryTree(4));
        root.getLeft().getRight().setLeft(new BinaryTree(5));
        root.getLeft().getRight().setRight(new BinaryTree(6));
        root.setRight(new BinaryTree(7));
        root.getRight().setLeft(new BinaryTree(8));
        root.getRight().setRight(new BinaryTree(9));

        List<Integer> test = new LinkedList<>();

        root.preOrder(test);
        System.out.print("preOrder:\t");
        for(Integer i: test)
            System.out.print(i + " ");
        System.out.println();

        test.clear();

        System.out.print("postOrder:\t");
        root.postOrder(test);
        for(Integer i: test)
            System.out.print(i + " ");
        System.out.println();

        test.clear();

        System.out.print("inOrder:\t");
        root.inOrder(test);
        for(Integer i: test)
            System.out.print(i + " ");
        System.out.println();
    }
}
