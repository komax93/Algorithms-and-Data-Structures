package section_1_3;


import java.io.*;
import java.util.*;

/**
 * Created by Maxim on 08.02.2016.
 */
public class FixedCapacityStackOfString
{
    private String[] a;
    private int N;

    public FixedCapacityStackOfString(int capacity)
    {
        a = new String[capacity];
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public void push(String item)
    {
        a[N++] = item;
    }

    public String pop()
    {
        return a[--N];
    }

    public int size()
    {
        return N;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        FixedCapacityStackOfString s = new FixedCapacityStackOfString(100);
        while (freader.hasNext())
        {
            String item = freader.next();
            if (!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty())
            {
                System.out.print(s.pop() + " ");
            }
        }

        System.out.println("Элементов в стеке: " + s.size());
    }
}
