package section_1_3.homework;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Maxim on 09.02.2016.
 */
public class StackWithPeek<Item> implements Iterable<Item>
{
    private int N = 0;
    private Node first;

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
        return N == 0;
    }

    public void push(Item value)
    {
        Node lastNode = first;
        first = new Node();
        first.item = value;
        first.next = lastNode;

        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;

        return item;
    }

    public Item peek()
    {
        return first.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>
    {
        private int mi = N;
        Node iterNode = first;

        @Override
        public boolean hasNext() {
            return mi > 0;
        }

        @Override
        public Item next() {
            Item item = iterNode.item;
            iterNode = iterNode.next;
            mi--;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\tobe.txt";
        Scanner freader = new Scanner(new File(filename));

        StackWithPeek<String> s = new StackWithPeek<String>();
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
        System.out.println(s.peek());
        for(String myS : s)
        {
            System.out.println(myS);
        }
    }
}
