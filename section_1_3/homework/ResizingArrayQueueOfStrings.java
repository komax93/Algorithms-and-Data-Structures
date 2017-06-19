package section_1_3.homework;

import section_1_3.ResizingArrayStack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 11.02.2016.
 */
public class ResizingArrayQueueOfStrings
{
    private int N = 0, D = 0;

    private String[] a = new String[1];

    public int size()
    {
        return N - D;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    private void resize(int max)
    {
        String[] temp = new String[max];
        for(int i = 0; i < N; i++)
            temp[i] = a[i];
        a = temp;
    }

    public void enqueue(String item)
    {
        a[N++] = item;
        if(N == a.length)
            resize(a.length * 2);
    }

    public String dequeue()
    {
        String value = a[D++];
        if(N > 0 && N == a.length / 4)
            resize(a.length / 2);

        return value;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        ResizingArrayQueueOfStrings s = new ResizingArrayQueueOfStrings();
        while(freader.hasNext())
        {
            String str = freader.next();
            if(!str.equals("-"))
                s.enqueue(str);
            else if(!str.isEmpty())
            {
                System.out.print(s.dequeue() + " ");
            }
        }
        System.out.println("Элементов в очереде: " + s.size());
    }
}
