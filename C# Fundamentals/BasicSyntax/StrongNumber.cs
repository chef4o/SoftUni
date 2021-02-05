using System;

namespace StrongNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int factorialDigitsSum = 0;
            for (int i = 0; i < Convert.ToString(n).Length; i++)
            {
                char digit = Convert.ToString(n)[i];

                int factorial = Int32.Parse($"{digit}");
                if (factorial == 0)
                {
                    factorial++;
                }

                for (int j = Int32.Parse($"{digit}") - 1; j > 1; j--)
                {
                    if (j == 0)
                    {
                        break;
                    }
                    factorial *= j;
                }

                factorialDigitsSum += factorial;
            }

            if (factorialDigitsSum == n)
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
