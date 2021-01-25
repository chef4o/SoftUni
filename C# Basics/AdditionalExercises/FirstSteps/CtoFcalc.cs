using System;

namespace CtoFcalc
{
    class Program
    {
        static void Main(string[] args)
        {
            double celsius = double.Parse(Console.ReadLine());

            double farenheit = (celsius * 9 / 5) + 32;

            Console.WriteLine($"{farenheit:f2}");
        }
    }
}
