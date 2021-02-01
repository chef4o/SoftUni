using System;

namespace SafePasswordGenerator
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int max = int.Parse(Console.ReadLine());

            int varA = 35;
            int varB = 64;
            int cycle = 1;

            for (int j = 1; j <= a; j++)
            {
                for (int k = 1; k <= b; k++)
                {
                    char charA = Convert.ToChar(varA);
                    char charB = Convert.ToChar(varB);

                    Console.Write($"{charA}{charB}{j}{k}{charB}{charA}|");

                    cycle++;
                    varA++;
                    if (varA > 55)
                    {
                        varA = 35;
                    }

                    varB++;
                    if (varB > 96)
                    {
                        varB = 64;
                    }

                    if (cycle > max)
                    {
                        break;
                    }

                }

                if (cycle > max)
                {
                    break;
                }
            }
        }
    }
}
