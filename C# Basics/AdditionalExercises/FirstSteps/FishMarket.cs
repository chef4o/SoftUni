using System;

namespace FishMarket
{
    class Program
    {
        static void Main(string[] args)
        {
            double mackerelPricePerKg = double.Parse(Console.ReadLine());
            double spratPricePerKg = double.Parse(Console.ReadLine());
            double bonitoQuantity = double.Parse(Console.ReadLine());
            double scadQuantity = double.Parse(Console.ReadLine());
            double musselQuantity = double.Parse(Console.ReadLine());

            double bonitoPricePerKg = mackerelPricePerKg + mackerelPricePerKg * 0.6;
            double scadPricePerKg = spratPricePerKg + spratPricePerKg * 0.8;
            double musslePricePerKg = 7.5;

            double bonitoFinalPrice = bonitoPricePerKg * bonitoQuantity;
            double scadFinalPrice = scadPricePerKg * scadQuantity;
            double musselFinalPrice = musselQuantity * musslePricePerKg;

            double neededMoney = bonitoFinalPrice + scadFinalPrice + musselFinalPrice;

            Console.WriteLine($"{neededMoney:f2}");

        }
    }
}
