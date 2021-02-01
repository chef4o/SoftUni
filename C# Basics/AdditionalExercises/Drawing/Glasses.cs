using System;

namespace Glasses
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                for (int j = 1; j <= (5 * n); j++)
                {
                    if (i == 0 || i == n - 1)
                    {
                        if (j <= n * 2 || j > (n * 3))
                        {
                            Console.Write("*");
                        }
                        else
                        {
                            Console.Write(" ");
                        }
                    }
                    else
                    {
                        if (j == 1 || j == (2 * n) || j == (3 * n) + 1 || j == (5 * n))
                        {
                            Console.Write("*");
                        }
                        else if ((j > 1 && j < 2 * n) || (j > (3 * n) + 1 && j < 5 * n))
                        {
                            Console.Write("/");
                        }
                        else
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
                    }
                }

                Console.WriteLine();
            }
        }
    }
}
