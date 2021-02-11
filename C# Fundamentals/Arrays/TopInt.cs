using System;
using System.Linq;

namespace TopInt
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine()
                                .Split()
                                .Select(int.Parse)
                                .ToArray();

            for (int i = 0; i < arr.Length; i++)
            {
                bool isTopInt = true;
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[j] >= arr[i])
                    {
                        isTopInt = false;
                    }
                }

                if (isTopInt)
                {
                    Console.Write($"{arr[i]} ");
                } 
            }
        }
    }
}
