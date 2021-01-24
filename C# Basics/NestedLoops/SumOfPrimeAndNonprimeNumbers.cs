using System;

namespace SumOfPrimeAndNonprimeNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int primeNumbers = 0;
            int nonPrimeNumbers = 0;

            while (true)
            {
                string input = Console.ReadLine();
                if (input == "stop")
                {
                    break;
                }

                if (int.Parse(input) < 0)
                {
                    Console.WriteLine("Number is negative.");
                }
                else
                {
                    bool isPrime = true;
                    for (int i = 2; i <= Math.Sqrt(int.Parse(input)); i++)
                    {
                        if (int.Parse(input) % i == 0)
                        {
                            isPrime = false;
                            break;
                        }
                    }

                    if (isPrime)
                    {
                        primeNumbers += int.Parse(input);
                    }
                    else
                    {
                    nonPrimeNumbers += int.Parse(input);
                    }
                }
            }

            Console.WriteLine($"Sum of all prime numbers is: {primeNumbers}\n" +
                              $"Sum of all non prime numbers is: {nonPrimeNumbers}");
        }
    }
}
