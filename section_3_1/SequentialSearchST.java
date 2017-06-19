package section_3_1;

/**
 * Created by Maxim on 04.03.2016.
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

    public boolean contains(Key key)
    {
        return get(key) != null;
    }

    public Value get(Key key)
    {
        for(Node x = first; x != null; x = x.next)
            if(key.equals(x.key))
                return x.value;
        return null;
    }

    public void delete(Key key)
    {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key)
    {
        if(x == null) return null;
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
            if(key.equals(x.key))
            {
                x.value = value;
                return;
            }
        first = new Node(key, value, first);
        N++;
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
