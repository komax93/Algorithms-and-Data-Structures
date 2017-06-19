package section_2_2.homework;

/**
 * Created by Maxim on 19.02.2016.
 */
public class MergeBU
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        aux = new Comparable[N];

        int count = 0;

        for(int sz = 1; sz < N; sz = sz + sz)
            for(int lo = 0; lo < N - sz && count <= 6; lo += sz + sz)
            {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
                count++;
            }
    }

    public static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo, j = mid + 1;

        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for(int k = lo; k <= hi; k++)
            if(i > mid)
                a[k] = aux[j++];
            else if(j > hi)
                a[k] = aux[i++];
            else if(less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }

    public static void main(String[] args)
    {
        /*Scanner scanner = new Scanner(new InputStreamReader(System.in));
        int arrayLength = scanner.nextInt();
        Integer[] array = new Integer[arrayLength];

        for(int i = 0; i < array.length; i++)
        {
            array[i] = scanner.nextInt();
        }*/

        Integer[] intArr = {55, 97, 79, 40, 53, 11, 58, 10, 92, 35};
        sort(intArr);
        show(intArr);
    }
}
