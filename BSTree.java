/*
 * CSC 205: Class 12247 / Online
 * Program: Program_3
 * Author: Trevor Ransom 36789334
 * Description: Recursion and Binary Trees (Program_3)
 */
public class BSTree<T extends Comparable <T>> implements Tree<T>
{
    //Creates nodes to store data in
    class Node
    {
        Node left;
        Node right;
        T data;

        //passes in data to node
        public Node(T data) {
            this.data = data;
        }
    }
    //creates the root node and a variable to store the size of the BSTree
       private Node root;
        int s;

        public BSTree()
        {
            s = 0;
        }

    //adds elements to the tree based on comparing passed in integers if item > root go (root.right) if < root go (root.left)
    @Override
    public void add(T item)
    {
        Node newNode = new Node(item);
        Node temp;
    if(root == null)
    {
        root = newNode;
        this.s++;
    }
    else
    {
        temp = root;
        while(true)
        {
            if(temp.data == item)
            {
                System.out.print("Element already exists, cannot add!");
            }
            if(temp.data.compareTo(item)>0)
            {
                if(temp.left == null)
                {
                    temp.left = newNode;
                    this.s++;
                    break;
                }
                if(temp.right == null)
                {
                    temp.right = newNode;
                    this.s++;
                    break;
                }
                else
                {
                    temp = temp.right;
                }
            }
        }
    }
    }

    //traverses the tree and finds matching element
    @Override
    public boolean contains(T item)
    {
        Node temp = this.root;
        while(temp !=null)
        {
            if (temp.data.compareTo(item)==0)
            {
                return true;
            }
            else if (temp.data.compareTo(item)>0)
            {
                temp=temp.left;
            }
            else
                temp = temp.right;
        }
        return false;
    }

    //returns number of nodes in tree
    @Override
    public int size() {
        return s;
    }

    //prints root in order
    @Override
    public void inOrderPrint()
    {
        System.out.print("The Tree in ascending order is: ");
        inOrder(this.root);
    }

    public void inOrder(Node root)
    {
        if(root == null)

            return;

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);

    }

    public String inOrder2nd(Node root, String text)
    {
        if (root == null)
            return text;

        text = inOrder2nd(root.left, text);
        text += root.data + " ";
        text = inOrder2nd(root.right, text);

        return text;
    }
    @Override
    public String toString()
    {
        String str = "";

        str = inOrder2nd(this.root, str);

        return str;
    }
}
