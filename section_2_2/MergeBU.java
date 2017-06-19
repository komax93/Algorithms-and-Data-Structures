package section_2_2;

/**
 * Created by Maxim on 20.02.2016.
 */
public class MergeBU
{
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        int N = a.length;
        aux = new Comparable[N];

        for(int sz = 1; sz < N; sz = sz + sz)
            for(int lo = 0; lo < N - sz; lo += sz + sz)
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
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

    private static boolean less(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    public static void show(Comparable[] a)
    {
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
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

        Character[] strArr1 = {'A', 'E', 'Q', 'S', 'U', 'Y', 'E', 'I', 'N', 'O', 'S'};
        Character[] strArr2 = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        Integer[] intArr1 = {111, 3, 52, 44, 1, 1919};

        sort(intArr1);
        show(intArr1);
    }
}
