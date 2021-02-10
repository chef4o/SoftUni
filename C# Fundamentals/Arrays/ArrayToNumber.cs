using System;
using System.Linq;

namespace ArrayToNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] input = Console.ReadLine()
                                 .Split()
                                 .Select(int.Parse)
                                 .ToArray();

            while (input.Length > 1)
            {
                int[] condense = new int[input.Length - 1];

                for (int i = 0; i < condense.Length; i++)
                {
                    condense[i] = input[i] + input[i + 1];
                }

                input = condense;
            }

            Console.WriteLine(input[0]);
        }
    }
}
