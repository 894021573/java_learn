package cn.demo;

public class BinaryTree
{
    private BinaryTree leftTree;
    private BinaryTree rightTree;

    private int value;

    public BinaryTree(int i)
    {
        this.value = i;
    }

    public BinaryTree getLeftTree()
    {
        return leftTree;
    }

    public void setLeftTree(BinaryTree leftTree)
    {
        this.leftTree = leftTree;
    }

    public BinaryTree getRightTree()
    {
        return rightTree;
    }

    public void setRightTree(BinaryTree rightTree)
    {
        this.rightTree = rightTree;
    }

    public static void main(String[] args)
    {
        BinaryTree binaryTree1 = new BinaryTree(1);
        BinaryTree binaryTree2 = new BinaryTree(2);
        BinaryTree binaryTree3 = new BinaryTree(3);
        BinaryTree binaryTree4 = new BinaryTree(4);
        BinaryTree binaryTree5 = new BinaryTree(5);

        binaryTree1.setLeftTree(binaryTree2);
        binaryTree1.setRightTree(binaryTree3);

        binaryTree2.setLeftTree(binaryTree4);
        binaryTree2.setRightTree(binaryTree5);

        /**
         *              1
         *           2     3
         *        4     5
         */

        // 中序遍历 中 左 右
        // 先序遍历 左 中 右
        // 后序遍历 左 右 中


    }

    public static void inTraverseTree(BinaryTree binaryTree)
    {

    }
}


