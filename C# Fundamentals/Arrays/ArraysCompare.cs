using System;
using System.Linq;

namespace ArraysCompare
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr1 = Console.ReadLine().Split(" ").ToArray();
            string[] arr2 = Console.ReadLine().Split(" ").ToArray();

            int outputCuonter = 0;
            string[] output = new string[arr1.Length];
            for (int i = 0; i < arr2.Length; i++)
            {
                for (int j = 0; j < arr1.Length; j++)
                {
                    if (arr1[j] == arr2[i])
                    {
                        output[outputCuonter] = arr1[j];
                        outputCuonter++;
                    }
                }
            }

            Console.WriteLine(string.Join(" ", output));
        }
    }
}
