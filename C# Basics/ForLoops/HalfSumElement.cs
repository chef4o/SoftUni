using System;
using System.Net.NetworkInformation;
using System.Runtime.InteropServices.ComTypes;
using System.Xml;

namespace HalfSumElement
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int sum = 0;
            string output = string.Empty;
            int max = int.MinValue;

            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                sum += number;

                if (number > max)
                {
                    max = number;
                }
            }

            if (sum / 2.0 - max == 0)
            {
                output = $"Yes\nSum = {max}";
            }
            else
            {
                output = $"No\nDiff = {Math.Abs(max - (sum - max))}";
            }

            Console.WriteLine(output);

        }
    }
}
