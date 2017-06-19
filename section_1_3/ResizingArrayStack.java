package section_1_3;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Maxim on 08.02.2016.
 */
public class ResizingArrayStack<Item> implements Iterable<Item>
{
    private int N = 0;
    private Item[] a = (Item[]) new Object[1];

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
        if(N == a.length)
            resize(a.length * 2);

        a[N++] = it;
    }

    public Item pop()
    {
        Item value = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length / 4)
            resize(a.length / 2);

        return value;
    }

    private void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++)
            temp[i] = a[i];

        a = temp;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while(freader.hasNextLine())
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
        for(String str : s)
            System.out.print(str + " ");
    }

    @Override
    public Iterator<Item> iterator() {
        return new newIterator();
    }

    public class newIterator implements Iterator
    {
        @Override
        public boolean hasNext() {
            return N > 0;
        }

        @Override
        public Object next() {
            return a[--N];
        }

        @Override
        public void remove() {

        }
    }
}