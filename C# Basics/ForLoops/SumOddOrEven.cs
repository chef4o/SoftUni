using System;

namespace SumOddOrEven
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int even = 0;
            int odd = 0;

            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());
                if (i % 2 == 0)
                {
                    even += number;
                }
                if (i % 2 != 0)
                {
                    odd += number;
                }
            }

            string output = string.Empty;
            if (even == odd)
            {
                output = $"Yes\nSum = {even}";
            }
            else
            {
                output = $"No\nDiff = {Math.Abs(even - odd)}";
            }

            Console.WriteLine(output);

        }
    }
}
