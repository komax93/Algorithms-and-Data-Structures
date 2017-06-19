package section_1_3;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Maxim on 09.02.2016.
 */
public class Queue<Item> implements Iterable<Item>
{
    private int N;
    private Node first;
    private Node last;

    class Node
    {
        Item item;
        Node next;
    }

    public int size()
    {
        return N;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty())
            last = null;
        return item;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>
    {
        Node myFirst = first;

        @Override
        public boolean hasNext()
        {
            return myFirst != null;
        }

        @Override
        public Item next()
        {
            Item myItem = myFirst.item;
            myFirst = myFirst.next;
            if(isEmpty())
                myFirst = null;
            return myItem;
        }

        @Override
        public void remove()
        {

        }
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        Queue<String> queue = new Queue<String>();
        while(freader.hasNext())
        {
            String str = freader.next();
            if(!str.equals("-"))
                queue.enqueue(str);
            else if(!queue.isEmpty())
            {
                System.out.print(queue.dequeue() + " ");
            }
        }
        System.out.println("Элементов в очереде: " + queue.size());
        for(String s : queue)
        {
            System.out.println(s);
        }
    }
}
