using System;
using System.Linq;

namespace ReverseStrings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] array = Console.ReadLine().Split().ToArray();
            string[] reverse = new string[array.Length];

            for (int i = array.Length - 1; i >= 0;)
            {
                for (int j = 0; j < array.Length; j++)
                {
                    reverse[j] = array[i];
                    i--;
                }
            }

            Console.WriteLine(string.Join(" ", reverse));
        }
    }
}   
