package section_2_4.homework;

/**
 * Created by Maxim on 01.03.2016.
 */
public class MinPQ<Key extends Comparable<Key>>
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

    private boolean greater(int i, int j)
    {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k)
    {
        while(k > 1 && greater(k / 2, k))
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
            if(j < N && greater(j, j + 1)) j++;
            if(!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }



    public void insert(Key value)
    {
        if(N == (pq.length - 1))
            resize(pq.length * 2);
        pq[++N] = value;
        swim(N);
    }

    public Key delMin()
    {
        exch(1, N);
        Key value = pq[N--];
        sink(1);
        pq[N + 1] = null;
        if(N > 0 && N == (pq.length - 1) / 4)
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
        MinPQ<Integer> PQ = new MinPQ<Integer>();
        PQ.insert(32);
        PQ.insert(1);
        PQ.insert(3);
        PQ.insert(12);
        PQ.insert(991);

        while (!PQ.isEmpty())
        {
            System.out.print(PQ.delMin() + " ");
        }
    }
}
