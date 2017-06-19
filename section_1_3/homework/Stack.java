package section_1_3.homework;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Maxim on 10.02.2016.
 */
public class Stack<Item> implements Iterable<Item>
{
    private int N;
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
        return first == null;
    }

    public void push(Item value)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = value;
        first.next = oldFirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;

        return item;
    }

    public boolean isParse(String str)
    {
        Stack<Character> s = new Stack<Character>();
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);

            if(c == '{')
                s.push(c);
            else if(c == '[')
                s.push(c);
            else if(c == '(')
                s.push(c);
            else if(c == '}')
            {
                if(s.isEmpty())
                    return false;
                else if(s.pop() == '{')
                {

                }
                else
                    return false;
            }
            else if(c == ']')
            {
                if(s.isEmpty())
                    return false;
                else if(s.pop() == '[')
                {

                }
                else
                    return false;
            }
            else if(c == ')')
            {
                if(s.isEmpty())
                    return false;
                else if(s.pop() == '(')
                {

                }
                else
                    return false;
            }
        }

        return s.isEmpty();
    }



    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\homework\\itwas.txt";
        Scanner freader = new Scanner(new File(filename));

        int N = 50;
        Stack<Integer> stack = new Stack<Integer>();
        while(N > 0)
        {
            stack.push(N % 2);
            N = N / 2;
        }

        for(int d : stack)
        {
            System.out.print(d);
        }
        System.out.println();
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
}
