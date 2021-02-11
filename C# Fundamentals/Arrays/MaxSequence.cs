using System;
using System.Linq;

namespace MaxSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = Console.ReadLine()
                                 .Split()
                                 .Select(int.Parse)
                                 .ToArray();

            int counter = 1;
            int value = array[0];
            int maxCounter = counter;
            int maxValue = value;

            for (int i = 0; i < array.Length - 1; i++)
            {
                value = array[i];
                if (array[i] == array[i + 1])
                {
                    counter++;
                }
                else
                {
                    counter = 1;
                }

                if (counter > maxCounter)
                {
                    maxCounter = counter;
                    maxValue = value;
                }
            }

            array = new int[maxCounter];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = maxValue;
            }

            Console.WriteLine(string.Join(" ", array));
        }
    }
}
