package section_3_4;

/**
 * Created by Maxim on 20.03.2016.
 */
public class SeparateChainingHashST<Key, Value>
{
    private int M;
    private int N;
    private SequentialSearchST<Key, Value>[] st;

    public int size()
    {
        return N;
    }

    public SeparateChainingHashST()
    {
        this(997);
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public SeparateChainingHashST(int M)
    {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key)
    {
        int i = hash(key);
        return (Value) st[i].get(key);
    }

    public void put(Key key, Value val)
    {
        int i = hash(key);
        st[i].put(key, val);
    }

    public static void main(String[] args)
    {
        SeparateChainingHashST<Integer, String> SQST = new SeparateChainingHashST<Integer, String>();
        SQST.put(1, "Maxim");
        SQST.put(33, "Ilo");
        SQST.put(4, "Ira");

        System.out.println(SQST.get(33));
    }
}
