package section_1_3.homework2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 26.02.2016.
 */
public class ResizingArrayStack<Item>
{
    private int N = 0;
    private Item[] id = (Item[]) new Object[1];

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return N == 0;
    }

    public void push(Item it)
    {
        if(N == id.length) resize(2 * id.length);
        id[N++] = it;
    }

    public Item pop()
    {
        Item it = id[--N];
        id[N] = null;
        if(N > 0 && N == id.length/4)
            resize(id.length / 2);

        return it;
    }

    public void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++)
            temp[i] = id[i];

        id = temp;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while(freader.hasNext())
        {
            String str = freader.next();
            if(!str.equals("-"))
                s.push(str);
            else if(!s.isEmpty())
            {
                System.out.print(s.pop() + " ");
            }
        }

        System.out.println("Элементов в стеке: " + s.size());
    }
}
