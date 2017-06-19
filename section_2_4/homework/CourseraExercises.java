package section_2_4.homework;

/**
 * Created by Maxim on 01.03.2016.
 */
public class CourseraExercises
{
    private int N;
    private Integer[] pq = new Integer[14];

    public CourseraExercises(Integer[] a)
    {
        for(int i = 0; i < a.length; i++)
            pq[i + 1] = a[i];

        N = a.length;
    }

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
        Integer temp = pq[i];
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

    public void insert(Integer k)
    {
        if(N == (pq.length - 1)) resize(pq.length * 2);
        pq[++N] = k;
        swim(N);
    }

    public Integer delMax()
    {
        Integer value = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if(N > 0 && N == (pq.length / 4))
            resize(pq.length / 2);
        return value;
    }

    private void resize(int max)
    {
        Integer[] temp = (Integer[]) new Comparable[max];
        for(int i = 1; i <= N; i++)
            temp[i] = pq[i];

        pq = temp;
    }

    public void show()
    {
        for(int i = 0; i < pq.length; i++)
            System.out.print(pq[i] + " ");
    }

    public static void main(String[] args)
    {
        /*Integer[] intArr = {96, 90, 92, 71, 51, 39, 60, 24, 42, 18};
        CourseraExercises maxPQ = new CourseraExercises(intArr);
        maxPQ.insert(20);
        maxPQ.insert(40);
        maxPQ.insert(35);
        maxPQ.show();*/

        Integer[] intArr = {97, 61, 60, 41, 49, 29, 23, 25, 36, 10};
        CourseraExercises maxPQ = new CourseraExercises(intArr);
        maxPQ.delMax();
        maxPQ.delMax();
        maxPQ.delMax();
        maxPQ.show();
    }
}
