package section_3_4;

import section_1_3.Queue;

/**
 * Created by Maxim on 21.03.2016.
 */
public class LinearProbingHashST<Key, Value>
{
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST()
    {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int capacity)
    {
        this.M = capacity;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
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

    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity)
    {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for(int i = 0; i < M; i++)
        {
            if(keys[i] != null)
                temp.put(keys[i], vals[i]);
        }

        keys = temp.keys;
        vals = temp.vals;
        M = temp.M;
    }

    public void put(Key key, Value val)
    {
        if(N >= M/2)
            resize(2 * M);
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % M)
            if(keys[i].equals(key))
            {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key)
    {
        for(int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }

    public void delete(Key key)
    {
        if(!contains(key))
            return;

        int i = hash(key);
        while(!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while(keys[i] != null)
        {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if(N > 0 && N == M / 8) resize(M / 2);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    public static void main(String[] args)
    {
        LinearProbingHashST<Integer, String> ph = new LinearProbingHashST<Integer, String>();
        ph.put(1, "Ukraine");
        ph.put(22, "United Kingdom");
        ph.put(2, "USA");
        ph.put(3, "Spain");

        System.out.println(ph.get(22));
        ph.delete(22);
        System.out.println(ph.get(22));
        System.out.println("Size of linear probing hash is: " + ph.size());
    }
}
