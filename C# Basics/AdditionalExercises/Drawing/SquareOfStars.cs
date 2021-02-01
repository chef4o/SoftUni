using System;

namespace SquareOfStars
{
    class Program
    {
        static void Main(string[] args)
        {
            int side = int.Parse(Console.ReadLine());

            for (int i = 0; i < side; i++)
            {
                for (int j = 0; j < side; j++)
                {
                    Console.Write("* ");
                }

                Console.WriteLine();

            }
        }
    }
}
