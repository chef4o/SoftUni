using System;

namespace ChristmasTree
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int row = 1; row <= n + 1; row++)
            {
                for (int i = 0; i <= n - row; i++)
                {
                    Console.Write(" ");
                }
                for (int j = 1; row - j > 0; j++)
                {
                    Console.Write("*");
                }
                Console.Write(" | ");
                for (int j = 1; row - j > 0; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
        }
    }
}
