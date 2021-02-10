using System;
using System.Linq;

namespace RoundingNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] input = Console.ReadLine()
                                    .Split()
                                    .Select(double.Parse)
                                    .ToArray();

            for (int i = 0; i < input.Length; i++)
            {
                if (input[i] == -0)
                {
                    input[i] = 0;
                }
                Console.WriteLine($"{input[i]} => {Convert.ToDecimal((Math.Round(input[i], MidpointRounding.AwayFromZero)))}");
            }
        }
    }
}