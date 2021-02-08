using System;

namespace GBPtoUSD
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal gbp = decimal.Parse(Console.ReadLine());
            double usdRate = 1.31;

            Console.WriteLine($"{gbp*(decimal)usdRate:f3}");
        }
    }
}
