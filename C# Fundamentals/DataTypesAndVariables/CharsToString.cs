using System;

namespace CharsToString
{
    class Program
    {
        static void Main(string[] args)
        {
            char a = char.Parse(Console.ReadLine());
            char b = char.Parse(Console.ReadLine());
            char c = char.Parse(Console.ReadLine());

            Console.Write(a.ToString() + b.ToString() + c.ToString());
        }
    }
}
