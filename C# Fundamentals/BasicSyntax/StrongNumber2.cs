using System;

namespace StrongNumber2
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            int checkNumber = number;
            int factorialSum = 0;
            while (number > 0)
            {
                int controlDigit = number % 10;
                number /= 10;

                int factorial = 1;
                for (int i = 1; i <= controlDigit; i++)
                {
                    factorial *= i;
                }

                factorialSum += factorial;
            }

            if (factorialSum == checkNumber)
            {
                Console.WriteLine("yes");
            }
            else
            {
                Console.WriteLine("no");
            }
        }
    }
}
