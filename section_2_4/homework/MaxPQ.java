package section_2_4.homework;

/**
 * Created by Maxim on 29.02.2016.
 */
public class MaxPQ<Key extends Comparable<Key>>
{
    private int N;
    private Key[] pq = (Key[]) new Comparable[1];

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k)
    {
        while(k > 1 && less(k / 2, k))
        {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k)
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

    public void insert(Key k)
    {
        if(N == (pq.length - 1)) resize(pq.length * 2);
        pq[++N] = k;
        swim(N);
    }

    public Key delMax()
    {
        Key value = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if(N > 0 && N == (pq.length / 4))
            resize(pq.length / 2);
        return value;
    }

    private void resize(int max)
    {
        Key[] temp = (Key[]) new Comparable[max];
        for(int i = 1; i <= N; i++)
            temp[i] = pq[i];

        pq = temp;
    }

    public static void main(String[] args)
    {
        MaxPQ<Character> maxPQ = new MaxPQ<Character>();
        maxPQ.insert('E');
        maxPQ.insert('A');
        maxPQ.insert('S');
        maxPQ.insert('Y');
        maxPQ.insert('Q');
        maxPQ.insert('U');
        maxPQ.insert('E');
        maxPQ.insert('S');
        maxPQ.insert('T');
        maxPQ.insert('I');
        maxPQ.insert('O');
        maxPQ.insert('N');

        while(!maxPQ.isEmpty())
            System.out.print(maxPQ.delMax() + " ");
            System.out.println("MaxPQ size: " + maxPQ.size());
    }
}
