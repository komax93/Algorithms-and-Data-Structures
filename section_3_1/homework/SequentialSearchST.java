package section_3_1.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Maxim on 06.03.2016.
 */
public class SequentialSearchST<Key, Value>
{
    private int N;
    private Node first;

    private class Node
    {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public void delete(Key key)
    {
        first = delete(first, key);
    }

    public Node delete(Node x, Key key)
    {
        if(x == null)
            return null;

        if(key.equals(x.key))
        {
            N--;
            return x.next;
        }

        x.next = delete(x.next, key);

        return x;
    }

    public void put(Key key, Value value)
    {
        if(value == null)
        {
            delete(key);
            return;
        }

        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key)) {
                x.value = value;
                return;
            }

        first = new Node(key, value, first);
        N++;
    }

    public Value get(Key key)
    {
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.value;

        return null;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SequentialSearchST<String, Double> ST = new SequentialSearchST<String, Double>();
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
    }
}
