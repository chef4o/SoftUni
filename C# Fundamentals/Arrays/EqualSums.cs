using System;
using System.Linq;

namespace EqualSums
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                           .Split()
                           .Select(int.Parse)
                           .ToArray();

            string equalIndex = "no";
            for (int i = 0; i < array.Length; i++)
            {
                int leftSum = 0;
                for (int j = 0; j <= i - 1; j++)
                {
                    leftSum += array[j];
                }

                int rightSum = 0;
                for (int k = i + 1; k < array.Length; k++)
                {
                    rightSum += array[k];
                }

                if (leftSum == rightSum)
                {
                    equalIndex = i.ToString();
                }
            }

            Console.WriteLine(equalIndex);
        }
    }
}
