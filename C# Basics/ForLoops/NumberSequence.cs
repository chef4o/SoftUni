using System;

namespace NumberSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int maxNumber = int.MinValue;
            int minNumber = int.MaxValue;

            for (int i = 0; i < n; i++)
            {
                int n1 = int.Parse(Console.ReadLine());

                if (n1 > maxNumber)
                {
                    maxNumber = n1;
                }
                if (n1 < minNumber)
                {
                    minNumber = n1;
                }

            }

            Console.WriteLine($"Max number: {maxNumber}");
            Console.WriteLine($"Min number: {minNumber}");

        }
    }
}
