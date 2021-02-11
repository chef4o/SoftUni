using System;
using System.Linq;

namespace ZigZag
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            for (int i = 0; i < n; i++)
            {
                int[] tempArray = Console.ReadLine()
                                         .Split()
                                         .Select(int.Parse)
                                         .ToArray();

                if (i % 2 == 0)
                {
                    arr1[i] = tempArray[0];
                    arr2[i] = tempArray[1];
                }
                else
                {
                    arr2[i] = tempArray[0];
                    arr1[i] = tempArray[1];
                }
            }

            Console.WriteLine($"{string.Join((" "), arr1)}\n{string.Join((" "), arr2)}");
        }
    }
}
