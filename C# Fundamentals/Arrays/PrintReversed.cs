using System;

namespace PrintReversed
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int[] list = new int[n];
            for (int i = 0; i < n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                list[i] = num;
            }
            for (int i = list.Length - 1; i >= 0; i--)
            {
                Console.Write($"{list[i]} ");
            }
        }
    }
}
