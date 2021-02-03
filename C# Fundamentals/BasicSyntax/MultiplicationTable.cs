using System;

namespace MultiplicationTable
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            for (int i = b; i <= 10; i++)
            {
                    Console.WriteLine($"{a} X {i} = {a * i}");
            }

            if (b > 10)
            {
                Console.WriteLine($"{a} X {b} = {a * b}");
            }

        }
    }
}
