using System;

namespace PrimePairs
{
    class Program
    {
        static void Main(string[] args)
        {
            int startA = int.Parse(Console.ReadLine());
            int startB = int.Parse(Console.ReadLine());
            int stepA = int.Parse(Console.ReadLine());
            int stepB = int.Parse(Console.ReadLine());

            int endA = startA + stepA;
            int endB = startB + stepB;

            for (int i = startA; i <= endA; i++)
            {
                bool aIsPrime = true;
                for (int y = 2; y <= Math.Sqrt(i); y++)
                {
                    if (i % y == 0)
                    {
                        aIsPrime = false;
                    }
                }

                for (int j = startB; j <= endB; j++)
                {
                    bool bIsPrime = true;
                    for (int z = 2; z <= Math.Sqrt(j) ; z++)
                    {
                        if (j % z == 0)
                        {
                            bIsPrime = false;
                            break;
                        }
                    }

                    if (aIsPrime && bIsPrime)
                    {
                        Console.WriteLine($"{i}{j}");
                    }    
                }
            }
        }
    }
}
