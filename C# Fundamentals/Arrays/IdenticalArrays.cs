using System;
using System.Linq;

namespace IdenticalArrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arrayOne = Console.ReadLine()
                                    .Split()
                                    .Select(int.Parse)
                                    .ToArray();
            int[] arrayTwo = Console.ReadLine()
                                    .Split()
                                    .Select(int.Parse)
                                    .ToArray();

            int sum = 0;
            bool identicalArrays = true;
            for (int i = 0; i < arrayOne.Length; i++)
            {
                for (int j = 0; j < arrayTwo.Length; j++)
                {
                    if (arrayOne[i] == arrayTwo[j])
                    {
                        sum += arrayOne[i];
                    }
                    else
                    {
                        identicalArrays = false;
                        Console.WriteLine($"Arrays are not identical. Found difference at {j} index");
                        break;
                    }

                    i++;
                }

                if (!identicalArrays)
                {
                    break;
                }
            }

            if (identicalArrays)
            {
                Console.WriteLine($"Arrays are identical. Sum: {sum}");
            }
        }
    }
}
