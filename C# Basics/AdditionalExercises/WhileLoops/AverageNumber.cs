using System;
using System.Transactions;

namespace AverageNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int score = 0;

            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                score += number;
            }

            double avg = score * 1.0 / n;

            Console.WriteLine($"{avg:f2}");
        }
    }
}
