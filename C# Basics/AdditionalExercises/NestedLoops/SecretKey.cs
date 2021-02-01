using System;

namespace SecretKey
{
    class Program
    {
        static void Main(string[] args)
        {
            int hundreds = int.Parse(Console.ReadLine());
            int tens = int.Parse(Console.ReadLine());
            int ones = int.Parse(Console.ReadLine());

            for (int i = 1; i <= hundreds; i++)
            {
                for (int j = 1; j <= tens; j++)
                {
                    bool isPrime = true;
                    for (int p = 2; p <= Math.Sqrt(j); p++)
                    {
                        if (j % p == 0)
                        {
                            isPrime = false;
                            break;
                        }
                    }

                    for (int k = 1; k <= ones; k++)
                    {
                        if (i % 2 == 0 && 
                            k % 2 == 0 && 
                          ((j >= 2 && j <=7) && isPrime))
                        {
                            Console.WriteLine($"{i} {j} {k}");
                        }
                    }
                }
            }
        }
    }
}
