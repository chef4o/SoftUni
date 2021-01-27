using System;

namespace EqualPairs2
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int sum = 0;
            int delta = 0;

            for (int i = 1; i <= n; i++)
            {

                int a1 = int.Parse(Console.ReadLine());
                int a2 = int.Parse(Console.ReadLine());

                if (i == 1)
                {
                    sum = a1 + a2;
                }
                else if (i > 1)
                {
                    delta = Math.Max(delta, Math.Abs(sum - a1 - a2));
                    sum = a2 + a1;
                }

            }

            if (delta == 0)
            {
                Console.WriteLine($"Yes, value={sum}");
            }
            else
            {
                Console.WriteLine($"No, maxdiff={delta}");
            }

        }
    }
}
