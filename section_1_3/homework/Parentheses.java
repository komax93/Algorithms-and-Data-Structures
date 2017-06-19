package section_1_3.homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 10.02.2016.
 */
public class Parentheses<Item>
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

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\homework\\itwas.txt";
        Scanner freader = new Scanner(new File(filename));

        Parentheses<Character> s = new Parentheses<Character>();
        String str1 = "[()]{}{[()()]()}"; //true
        String str2 = "[(])"; //false
        String str3 = "{}";

        System.out.println("Is parse equals: " + s.isParse(str1));
    }

    public boolean isParse(String str)
    {
        Parentheses<Character> s = new Parentheses<Character>();
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
}
