using System;

namespace UniquePINs
{
    class Program
    {
        static void Main(string[] args)
        {
            int x1 = int.Parse(Console.ReadLine());
            int x2 = int.Parse(Console.ReadLine());
            int x3 = int.Parse(Console.ReadLine());

            for (int i = 1; i <= x1; i++)
            {
                for (int j = 2; j <= x2; j++)
                {
                    bool jPrime = true;
                    for (int s = 2; s <= Math.Sqrt(j) ; s++)
                    {
                        if (j % s == 0)
                        {
                            jPrime = false;
                            break;
                        }
                    }

                        for (int k = 1; k <= x3; k++)
                        {
                            if (i % 2 == 0 && (j <= Math.Min(7, x2) && jPrime) && k % 2 == 0)
                            {
                                Console.WriteLine($"{i} {j} {k}");
                            }
                        }
                }
            }
        }
    }
}
