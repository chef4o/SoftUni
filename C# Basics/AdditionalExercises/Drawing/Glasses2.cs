using System;

namespace Glasses2
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                for (int j = 1; j <= 2 * n; j++)
                {
                    if ((i != 0 && i != n - 1) && (j > 1 && j < 2 * n))
                    {
                        Console.Write("/");
                    }
                    else 
                    {
                        Console.Write("*");
                    }
                }
                for (int j = 1; j <= n; j++)
                {
                    if ((n % 2 == 0 && i == (n / 2) - 1) || (n % 2 != 0 && i == n / 2))
                    {
                        Console.Write("|");
                    }
                    else
                    {
                        Console.Write(" ");
                    }
                }
                for (int j = 1; j <= 2 * n; j++)
                {
                    if ((i != 0 && i != n - 1) && (j > 1 && j < 2 * n))
                    {
                        Console.Write("/");
                    }
                    else
                    {
                        Console.Write("*");
                    }
                }

                Console.WriteLine();
            }
        }
    }
}
