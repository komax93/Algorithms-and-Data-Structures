package section_1_3;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Maxim on 09.02.2016.
 */
public class MyOwnStack<Item> implements Iterable<Item>
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

    public void push(Item i)
    {
        Node oldNode = first;
        first = new Node();
        first.item = i;
        first.next = oldNode;

        N++;
    }

    public Item pop()
    {
        Item myItem = first.item;
        first = first.next;
        N--;
        return myItem;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIter();
    }

    private class MyIter implements Iterator<Item>
    {
        private int i = N;
        private Node myNode = first;

        @Override
        public boolean hasNext()
        {
            return i > 0;
        }

        @Override
        public Item next()
        {
            Item n = myNode.item;
            myNode = myNode.next;
            i--;
            return n;
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

        MyOwnStack<String> myOwnStack = new MyOwnStack<String>();
        while (freader.hasNext())
        {
            String str = freader.next();
            if(!str.equals("-"))
                myOwnStack.push(str);
            else if(!myOwnStack.isEmpty())
                System.out.print(myOwnStack.pop() + " ");
        }
        System.out.println("В стеке элементов: " + myOwnStack.size());
        for(String myS : myOwnStack)
        {
            System.out.println(myS);
        }
    }
}
