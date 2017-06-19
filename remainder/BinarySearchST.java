package remainder;

/**
 * Created by Maxim on 11.03.2016.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value>
{
    private int N;
    private Key[] keys;
    private Value[] vals;

    public BinarySearchST(int capacity)
    {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public int rank(Key key)
    {
        int lo = 0, hi = N - 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp < 0)
                hi = mid - 1;
            else if(cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public void put(Key key, Value val)
    {
        int i = rank(key);

        if(i < N && key.compareTo(keys[i]) == 0) {
            vals[i] = val;
            return;
        }

        for(int j = N; j > i; j--)
        {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key)
    {
        if(key == null)
            return null;

        int i = rank(key);

        if(i < N && key.compareTo(keys[i]) == 0)
            return vals[i];
        else
            return null;
    }

    public static void main(String[] args)
    {
        BinarySearchST<Integer, String> sq = new BinarySearchST<Integer, String>(50);
        sq.put(1, "Maxim Kolesnikov");
        sq.put(22, "Iradion");
        sq.put(3, "Igor");

        System.out.println(sq.get(3));
    }
}
