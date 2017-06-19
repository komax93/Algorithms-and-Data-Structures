package section_3_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Maxim on 12.03.2016.
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

    private boolean isRed(Node x)
    {
        if(x == null)
            return false;
        return x.color == RED;
    }

    public int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if(x == null)
            return 0;

        return x.N;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    private Node rotateLeft(Node h)
    {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
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
        h.N = 1 + size(h.left) + size(h.right);
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

    private Value get(Node x, Key key)
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

    private Node put(Node h, Key key, Value val)
    {
        if(h == null)
            return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);
        if(cmp < 0)
            h.left = put(h.left, key, val);
        else if(cmp > 0)
            h.right = put(h.right, key, val);
        else
            h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && !isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RedBlackBST<String, Double> ST = new RedBlackBST<String, Double>();
        Double sum = 0.0, i = 0.0, avg;

        ST.put("A+", 4.33);
        ST.put("A", 4.00);
        ST.put("A-", 3.67);
        ST.put("B+", 3.33);
        ST.put("B", 3.00);
        ST.put("B-", 2.67);
        ST.put("C+", 2.33);
        ST.put("C", 2.00);
        ST.put("C-", 1.67);
        ST.put("D", 1.00);
        ST.put("F", 0.00);

        System.out.println("Please insert symbol assessment:");
        while(true)
        {
            String symbol = reader.readLine();
            if(symbol.equals("exit"))
                break;

            Double assessment = ST.get(symbol);
            sum += assessment;
            i++;
        }

        avg = sum / i;
        System.out.println("The average value of assessment is: " + avg);
        /*System.out.println("Min: " + ST.min());
        System.out.println("Max: " + ST.max());
        System.out.println("Floor: " + ST.floor("B"));
        System.out.println("Ceiling: " + ST.floor("B"));
        System.out.println("Select: " + ST.select(5));
        System.out.println("Rank: " + ST.rank("F"));*/

    }
}
