package section_1_3.homework2;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Maxim on 26.02.2016.
 */
public class Stack<Item> implements Iterable<Item>
{
    private int N;
    Node first;

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

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;

        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;

        return item;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>
    {
        Node myNode = first;

        @Override
        public boolean hasNext()
        {
            return myNode != null;
        }

        @Override
        public Item next()
        {
            Item myItem = myNode.item;
            myNode = myNode.next;
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

        Stack<String> s = new Stack<String>();
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

        for(String myS : s)
        {
            System.out.println(myS);
        }
    }
}