package section_1_3.homework2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 26.02.2016.
 */
public class Queue<Item>
{
    private int N;
    private Node first, last;

    private class Node
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
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty())
            first = last;
        else
            oldlast.next = last;

        N++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if(isEmpty())
            first = null;
        N--;
        return item;
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
    }
}
