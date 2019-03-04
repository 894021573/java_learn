package cn.algorithm;

public class Linked
{
    public static void main(String[] args)
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.append(node2).append(node3).append(new Node(4));

        node1.show();
        node1.removeNext();
        node1.show();

        node1.after(node2);
        node1.show();

        // 循环链表
        LoopNode loopNode1 = new LoopNode(1);
        LoopNode loopNode2 = new LoopNode(2);
        LoopNode loopNode3 = new LoopNode(3);
        LoopNode loopNode4 = new LoopNode(4);
        LoopNode loopNode5 = new LoopNode(5);

        loopNode1.after(loopNode2);
        loopNode2.after(loopNode3);
        loopNode3.after(loopNode4);

        System.out.println(loopNode1.getNext().getData());
        System.out.println(loopNode2.getNext().getData());
        System.out.println(loopNode3.getNext().getData());
        System.out.println(loopNode4.getNext().getData());
    }
}

// 链表
class Node
{
    private int data;
    private Node next;

    Node(int data)
    {
        this.data = data;
    }

    // 添加
    public Node append(Node node)
    {
        Node currentNode = this;
        while (true)
        {
            Node next = currentNode.getNext();

            if (next == null)
            {
                break;
            }

            currentNode = next;
        }

        currentNode.setNext(node);
        return node;
    }

    // 插入
    public void after(Node node)
    {
        Node next = this.getNext();
        this.setNext(node);
        node.setNext(next);
    }

    // 删除
    public void removeNext()
    {
        Node nextNext = this.getNext().getNext();
        this.setNext(nextNext);
    }

    public int getData()
    {
        return this.data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node node)
    {
        this.next = node;
    }

    public void show()
    {
        Node currentNode = this;
        while (true)
        {
            System.out.print(currentNode.getData());
            if (currentNode.getNext() != null)
            {
                currentNode = currentNode.getNext();
            } else
            {
                break;
            }
        }

        System.out.println();
    }
}

// 单向循环链表
class LoopNode
{
    private int data;
    private LoopNode next = this;

    LoopNode(int data)
    {
        this.data = data;
    }


    // 插入
    public void after(LoopNode node)
    {
        LoopNode next = this.getNext();
        this.setNext(node);
        node.setNext(next);
    }

    public int getData()
    {
        return this.data;
    }

    public LoopNode getNext()
    {
        return next;
    }

    public void setNext(LoopNode node)
    {
        this.next = node;
    }
}

// 双向循环链表
