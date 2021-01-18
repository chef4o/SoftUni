using System;

namespace LeftRightSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int leftSum = 0;
            for (int i = 0; i < n; i++)
            {
                    leftSum += int.Parse(Console.ReadLine());
            }

            int rightSum = 0;
            for (int i = 0; i < n; i++)
            {
                rightSum += int.Parse(Console.ReadLine());
            }

            string output = string.Empty;

            if (leftSum == rightSum)
            {
                output = $"Yes, sum = {leftSum}";
            }
            else
            {
                output = $"No, diff = {Math.Abs(rightSum - leftSum)}";
            }

            Console.WriteLine(output);

        }
    }
}
