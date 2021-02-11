using System;
using System.Linq;

namespace Rotation
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                                  .Split()
                                  .Select(int.Parse)
                                  .ToArray();
            int n = int.Parse(Console.ReadLine());

            while (n > 0)
            {
                int oldZero = array[0];
                for (int i = 0; i < array.Length - 1; i++)
                {
                    array[i] = array[i + 1];
                }
                array[array.Length - 1] = oldZero;

                n--;
            }

            Console.WriteLine(string.Join(" ", array));
        }
    }
}
