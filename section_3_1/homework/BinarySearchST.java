package section_3_1.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Maxim on 06.03.2016.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value>
{
    private int N;
    private Key[] keys;
    private Value[] vals;

    public BinarySearchST(int cap)
    {
        keys = (Key[]) new Comparable[cap];
        vals = (Value[]) new Object[cap];
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    private int rank(Key key)
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

        if(i < N && key.compareTo(keys[i]) == 0)
        {
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
        if(isEmpty())
            return null;

        int i = rank(key);

        if(i < N && key.compareTo(keys[i]) == 0)
            return vals[i];
        else
            return null;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchST<String, Double> ST = new BinarySearchST<String, Double>(50);
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
