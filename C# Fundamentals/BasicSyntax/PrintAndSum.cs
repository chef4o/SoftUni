﻿using System;

namespace PrintAndSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());

            int sum = 0;

            for (int i = a; i <= b; i++)
            {
                Console.Write($"{i} ");
                sum += i;
            }

            Console.WriteLine($"\nSum: {sum}");
        }
    }
}
