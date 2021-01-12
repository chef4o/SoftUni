using System;

namespace FruitMarket
{
    class Program
    {
        static void Main(string[] args)
        {
            double strawberyPrice = double.Parse(Console.ReadLine());
            double bananas = double.Parse(Console.ReadLine());
            double oranges = double.Parse(Console.ReadLine());
            double rabsbery = double.Parse(Console.ReadLine());
            double strawbery = double.Parse(Console.ReadLine());

            double rabsberyPrice = strawberyPrice / 2;
            double orangePrice = rabsberyPrice - (rabsberyPrice * 0.4);
            double bananaPrice = rabsberyPrice - (rabsberyPrice * 0.8);

            double strawberySum = strawbery * strawberyPrice;
            double rabsberySum = rabsbery * rabsberyPrice;
            double orangeSum = oranges * orangePrice;
            double bananaSum = bananas * bananaPrice;

            double totalSum = strawberySum + rabsberySum + orangeSum + bananaSum;

            Console.WriteLine(Math.Round(totalSum , 2));

        }
    }
}
