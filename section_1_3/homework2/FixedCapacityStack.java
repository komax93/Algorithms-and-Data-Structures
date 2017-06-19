package section_1_3.homework2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 26.02.2016.
 */
public class FixedCapacityStack<Item>
{
    private int N;
    private Item[] id;

    public FixedCapacityStack(int size)
    {
        id = (Item[]) new Object[size];
    }

    public int count()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public void push(Item item)
    {
        id[N++] = item;
    }

    public Item pop()
    {
        return id[--N];
    }

    public int size()
    {
        return N;
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
