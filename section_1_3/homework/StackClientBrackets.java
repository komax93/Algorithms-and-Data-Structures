package section_1_3.homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maxim on 10.02.2016.
 */
public class StackClientBrackets<Item>
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

    public Item peek()
    {
        return first.item;
    }

    public static void main(String[] args) throws IOException
    {
        String filename = "C:\\Users\\Maxim\\IdeaProjects\\Sedjevic_Assignments\\src\\section_1_3\\homework\\itwas.txt";
        Scanner freader = new Scanner(new File(filename));

        StackClientBrackets<String> s = new StackClientBrackets<String>();
        String str1 = "[()]{}{[()()]()}"; //true
        String str2 = "[(])"; //false
        String str3 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String str4 = "( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )";
        String str5 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String str6 = "5 + 6 ) + 6)";
        String str7 = "3 + 5";

        System.out.println(correct(str3) + " = " + calculate(correct(str3)));
    }

    public static String correct(String str)
    {
        StackClientBrackets<String> stack = new StackClientBrackets<String>();
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            switch (ch)
            {
                case '0': case '1': case '2': case '3': case '4': case '5':
                case '6': case '7': case '8': case '9':
                    if(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0)))
                        stack.push(stack.pop() + ch);
                    else
                        stack.push(Character.toString(ch));
                    break;
                case '+': case '-': case '*': case '/':
                    stack.push(Character.toString(ch));
                    break;
                case ' ': case '\t':
                    break;
                case ')':
                    String right = stack.pop();
                    String operator = stack.pop();
                    String left = stack.pop();
                    stack.push(String.format("( %s %s %s )", left, operator, right));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown char: " + Character.toString(ch));
            }
        }
        if(stack.size() != 1)
            throw new IllegalArgumentException("Invalid input: " + str);

        return stack.pop();
    }

    public static double calculate(String str)
    {
        StackClientBrackets<Character> sChar = new StackClientBrackets<Character>();
        StackClientBrackets<Double> sDouble = new StackClientBrackets<Double>();
        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if(c == '('){}
            else if(c == '+')
                sChar.push(c);
            else if(c == '-')
                sChar.push(c);
            else if(c == '*')
                sChar.push(c);
            else if(c == '/')
                sChar.push(c);
            else if(c == ')')
            {
                double dValue = sDouble.pop();
                char cValue = sChar.pop();

                if(cValue == '+')
                    dValue += sDouble.pop();
                else if(cValue == '*')
                    dValue *= sDouble.pop();
                else if(cValue == '-')
                    dValue -= sDouble.pop();
                else if(cValue == '/')
                    dValue /= sDouble.pop();

                sDouble.push(dValue);
            }
            else if(c == ' '){}
            else
                sDouble.push(Double.parseDouble(Character.toString(c)));
        }
        return sDouble.pop();
    }

    public boolean isParse(String str)
    {
        StackClientBrackets<Character> s = new StackClientBrackets<Character>();
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
