package section_1_3;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Maxim on 10.02.2016.
 */
public class Bag<Item> implements Iterable<Item>
{
    Node first;
    int N;

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

    public void add(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item>
    {
        Node myFirst = first;
        @Override
        public boolean hasNext() {
            return myFirst != null;
        }

        @Override
        public Item next() {
            Item item = myFirst.item;
            myFirst = myFirst.next;
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

        Bag<String> bag = new Bag<String>();
        while(freader.hasNext())
        {
            String str = freader.next();
            bag.add(str);
        }

        for(String str : bag)
        {
            System.out.print(str + " ");
        }
    }
}
