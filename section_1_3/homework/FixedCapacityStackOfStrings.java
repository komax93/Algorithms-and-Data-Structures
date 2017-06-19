package section_1_3.homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 10.02.2016.
 */
public class FixedCapacityStackOfStrings
{
    private int N;
    private String[] a;

    public FixedCapacityStackOfStrings(int count)
    {
        a = new String[count];
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public boolean isFull()
    {
        return N  >= a.length;
    }

    public void push(String value)
    {

        a[N++] = value;
    }

    public String pop()
    {
        return a[--N];
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(14);
        while (freader.hasNext())
        {
            String item = freader.next();
            if(!s.isFull())
                s.push(item);
        }

        System.out.println("Элементов в стеке: " + s.size());
        System.out.println("Is full stack: " + s.isFull());
    }
}
