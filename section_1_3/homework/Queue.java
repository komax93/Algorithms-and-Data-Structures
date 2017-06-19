package section_1_3.homework;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Maxim on 11.02.2016.
 */
public class Queue<Item>
{
    private int N = 0;
    private Node first;
    private Node last;

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
            first = last;
        N--;
        return item;
    }

    public Item countFromEnd(int numb)
    {
        int position = N - numb;
        Item item;
        for(int i = 0; i < position; i++)
        {
            first = first.next;

        }
        item = first.item;
        return item;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new InputStreamReader(System.in));

        Queue<String> queue = new Queue<String>();
        for(int i = 0; i < 5; i++)
        {
            String str = freader.next();
                queue.enqueue(str);
        }
        int position = freader.nextInt();

        System.out.println("Элементов в очереде: " + queue.size());
        System.out.println("Элемент " + position + "-й с конца: " + queue.countFromEnd(position));
    }
}
