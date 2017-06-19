package section_1_3.homework2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 26.02.2016.
 */
public class FixedCapacityStackOfString
{
    private int N;
    private String[] id;

    public FixedCapacityStackOfString(int size)
    {
        id = new String[size];
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public void push(String item)
    {
        id[N++] = item;
    }

    public String pop()
    {
        return id[--N];
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
