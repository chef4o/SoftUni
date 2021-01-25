using System;

namespace CircleArea
{
    class Program
    {
        static void Main(string[] args)

        {
            double r = double.Parse(Console.ReadLine());

            double d = 2 * Math.PI * r;
            double p = Math.PI * r * r;

            Console.WriteLine($"{p:f2}\n{d:f2}");

        }
    }
}
