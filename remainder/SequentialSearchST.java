package remainder;

/**
 * Created by Maxim on 11.03.2016.
 */
public class SequentialSearchST<Key, Value>
{
    private int N;
    private Node first;
    private class Node
    {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
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

    public void put(Key key, Value val)
    {
        if(key == null)
            return;

        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
            {
                x.val = val;
                return;
            }

        first = new Node(key, val, first);
        N++;
    }

    public Value get(Key key)
    {
        if(key == null)
            return null;

        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.val;
        return null;
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

    public static void main(String[] args)
    {
        SequentialSearchST<Integer, String> sq = new SequentialSearchST<Integer, String>();
        sq.put(1, "Maxim Kolesnikov");
        sq.put(22, "Iradion");
        sq.delete(22);
        sq.put(3, "Igor");

        System.out.println(sq.get(22));
    }
}
