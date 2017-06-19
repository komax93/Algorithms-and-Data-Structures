package section_3_3.homework;

/**
 * Created by Maxim on 13.03.2016.
 */

public class RedBlackBST<Key extends Comparable<Key>, Value>
{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node
    {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N;

        public Node(Key key, Value val, boolean color, int n) {
            this.key = key;
            this.val = val;
            this.color = color;
            N = n;
        }
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.N;
    }

    private boolean isRed(Node h)
    {
        if(h == null)
            return false;
        else
            return h.color == RED;
    }

    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;

        return x;
    }

    private Node rotateRight(Node h)
    {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;

        return x;
    }

    private void flipColors(Node h)
    {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public Value get(Key key)
    {
        return get(root, key);
    }

    public Value get(Node x, Key key)
    {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);

        if(cmp < 0)
            return get(x.left, key);
        else if(cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    public void put(Key key, Value val)
    {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value val)
    {
        if(x == null)
            return new Node(key, val, RED, 1);

        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left, key, val);
        else if(cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;

        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right)) flipColors(x);

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args)
    {
        RedBlackBST<Integer, String> RBBST = new RedBlackBST<Integer, String>();
        RBBST.put(1, "Maxim Kolesnikov");
        RBBST.put(2, "Resan Chogadze");
        RBBST.put(3, "Svjatoslav Vakarchuk");
        RBBST.put(4, "Irina Andrejchyk");
        RBBST.put(5, "Ilo Bolkvadze");

        for(int i = 1; i <= 5; i++)
            System.out.println(RBBST.get(i));
        System.out.println("Size of RedBlackBST is: " + RBBST.size());
    }
}