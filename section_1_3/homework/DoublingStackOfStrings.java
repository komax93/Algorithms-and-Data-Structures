package section_1_3.homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 11.02.2016.
 */
public class DoublingStackOfStrings
{
    private int N = 0;
    private String[] a = new String[1];

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public int arraySize()
    {
        return a.length;
    }

    public void resize(int max)
    {
        String[] temp = new String[max];
        for(int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void push(String str)
    {
        a[N++] = str;
        if(N == a.length)
            resize(a.length * 2);
    }

    public String pop()
    {
        String str = a[--N];
        if(N > 0 && (N == a.length / 4))
            resize(a.length / 2);

        return str;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\homework\\itwas.txt";
        Scanner freader = new Scanner(new File(filename));

        DoublingStackOfStrings s = new DoublingStackOfStrings();
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

        System.out.println("Размер массива: " + s.arraySize());
    }
}
