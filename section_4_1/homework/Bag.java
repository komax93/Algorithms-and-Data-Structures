package section_4_1.homework;
/**
 * Created by Maxim on 11.04.2016.
 */
import java.util.*;

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
        N = 0;
        first = null;
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

    @Override
    public Iterator<Item> iterator()
    {
        return new MyIterator<Item>(first);
    }

    private class MyIterator<Item> implements Iterator<Item>
    {
        private Node<Item> nodeTemp;

        public MyIterator(Node<Item> nodeTemp)
        {
            this.nodeTemp = nodeTemp;
        }

        @Override
        public boolean hasNext() {
            return nodeTemp != null;
        }

        @Override
        public Item next() {
            Item item = nodeTemp.item;
            nodeTemp = nodeTemp.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
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
