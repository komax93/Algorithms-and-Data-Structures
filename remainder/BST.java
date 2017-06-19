package remainder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Maxim on 11.03.2016.
 */
public class BST<Key extends Comparable<Key>, Value>
{
    private Node root;
    private class Node
    {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size()
    {
        return size(root);
    }

    public int size(Node x)
    {
        if(x == null)
            return 0;
        else
            return x.N;
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
            return x.value;
    }

    public void put(Key key, Value value)
    {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value val)
    {
        if(x == null)
            return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = put(x.left, key, val);
        else if(cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.value = val;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BST<String, Double> ST = new BST<String, Double>();
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
