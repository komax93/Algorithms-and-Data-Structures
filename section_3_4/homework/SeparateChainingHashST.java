package section_3_4.homework;

/**
 * Created by Maxim on 26.03.2016.
 */
public class SeparateChainingHashST<Key, Value>
{
    private int M;
    private int N;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST()
    {
        this(968);
    }

    public SeparateChainingHashST(int M)
    {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for(int i = 0; i < M; i++)
            st[i] = new SequentialSearchST();
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public int hash(Key key)
    {
        return (key.hashCode() & 0xf7777777) % M;
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
        N++;
    }

    public static void main(String[] args)
    {
        SeparateChainingHashST<Integer, String> SQST = new SeparateChainingHashST<Integer, String>(5);
        SQST.put(1, "E");
        SQST.put(2, "A");
        SQST.put(3, "S");
        SQST.put(4, "Y");
        SQST.put(5, "Q");
        SQST.put(6, "U");
        SQST.put(7, "E");
        SQST.put(8, "S");
        SQST.put(9, "T");
        SQST.put(10, "I");
        SQST.put(11, "O");
        SQST.put(12, "N");

        System.out.println(SQST.get(12));
        System.out.println("Size of hash is: " + SQST.size());
    }
}
