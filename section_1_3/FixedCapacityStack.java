package section_1_3;

import java.io.*;
import java.util.*;

/**
 * Created by Maxim on 08.02.2016.
 */
public class FixedCapacityStack<Item>
{
    private int N;
    private Item[] a;

    public FixedCapacityStack(int cap)
    {
        a = (Item[]) new Object[cap];
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public void push(Item p)
    {
        a[N++] = p;
    }

    public Item pop()
    {
        return a[--N];
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
        while(freader.hasNext())
        {
            String str = freader.next();
            if(!str.equals("-"))
                s.push(str);
            else if(!str.isEmpty())
            {
                System.out.print(s.pop() + " ");
            }
        }
        System.out.println("Элементов в стеке: " + s.size());
    }
}
