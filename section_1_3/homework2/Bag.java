package section_1_3.homework2;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Maxim on 26.02.2016.
 */

public class Bag<Item> implements Iterable<Item>
{
    private Node first;
    private int N;

    private class Node
    {
        Item item;
        Node next;
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
    public Iterator<Item> iterator()
    {
        return new myIter();
    }

    private class myIter implements Iterator<Item>
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
            Item it = myNode.item;
            myNode = myNode.next;

            return it;
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
