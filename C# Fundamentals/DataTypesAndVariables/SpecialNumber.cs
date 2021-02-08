using System;

namespace SpecialNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i++)
            {
                int sumOfDigits = 0; 
                int j = i;
                while (j > 0)
                {
                    sumOfDigits += j % 10;
                    j = j / 10;
                }

                bool isSpecia = (sumOfDigits == 5 || 
                                 sumOfDigits == 7 || 
                                 sumOfDigits == 11);

                Console.WriteLine($"{i} -> {isSpecia}");
            }
        }
    }
}
