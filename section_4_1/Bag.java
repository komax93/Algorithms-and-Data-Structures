package section_4_1;

import java.util.*;
/**
 * Created by Maxim on 30.03.2016.
 */
public class Bag<Item> implements Iterable<Item>
{
    private Node<Item> first;
    private int N;

    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }

    public Bag()
    {
        first = null;
        N = 0;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }

    public void add(Item item)
    {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;

        public ListIterator(Node<Item> first)
        {
            current = first;
        }

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args)
    {
        Bag<Integer> bag = new Bag<Integer>();
        bag.add(23);
        bag.add(3);
        bag.add(1);

        for(Integer i : bag)
            System.out.print(i + " ");
    }
}