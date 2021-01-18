using System;
using System.Dynamic;
using System.Security.Cryptography;

namespace CleverLili
{
    class Program
    {
        static void Main(string[] args)
        {
            int age = int.Parse(Console.ReadLine());
            double wmPrice = double.Parse(Console.ReadLine());
            int toyPrice = int.Parse(Console.ReadLine());

            double savings = 0.0;
            int toys = 0;

            for (int i = 1; i <= age; i++)
            {
                if (i % 2 == 0)
                {
                    savings = savings + (i * 5 - 1);
                }
                if (i %2 != 0)
                {
                    toys += 1;
                }
            }

            double difference = (savings + (toys * toyPrice)) - wmPrice;

            string output = string.Empty;
            if (difference >= 0)
            {
                output = $"Yes! {difference:f2}";
            }
            else
            {
                output = $"No! {Math.Abs(difference):f2}";
            }

            Console.WriteLine(output);
        }
    }
}
