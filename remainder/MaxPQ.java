package remainder;

/**
 * Created by Maxim on 10.03.2016.
 */
public class MaxPQ<Item extends Comparable<Item>>
{
    private int N;
    private Item[] pq;

    public MaxPQ(int capacity)
    {
        N = 0;
        pq = (Item[]) new Comparable[capacity];
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j)
    {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public void swim(int k)
    {
        while(k > 1 && less(k / 2, k))
        {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    public void sink(int k)
    {
        while(2 * k <= N)
        {
            int j = 2 * k;
            if(j < N && less(j, j + 1)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public void insert(Item key)
    {
        pq[++N] = key;
        swim(N);
    }

    public Item delMax()
    {
        Item key = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);

        return key;
    }

    public static void main(String[] args)
    {
        MaxPQ<Integer> pq = new MaxPQ<Integer>(50);
        pq.insert(999);
        pq.insert(3);
        pq.insert(1);
        pq.insert(135);
        pq.insert(9999);
        pq.insert(312);
        pq.insert(2);
        pq.insert(1010);

        while(!pq.isEmpty())
        {
            System.out.print(pq.delMax() + " ");
        }
    }
}
