using System;
using System.Reflection;

namespace FlowerShop
{
    class Program
    {
        static void Main(string[] args)
        {
            int chrysanthemums = int.Parse(Console.ReadLine());
            int roses = int.Parse(Console.ReadLine());
            int tulips = int.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            string isHoliday = Console.ReadLine();

            double price = 0;

            switch (season)
            {
                case "Spring":
                case "Summer":
                    price = chrysanthemums * 2 + roses * 4.1 + tulips * 2.5;
                    break;
                case "Autumn":
                case "Winter":
                    price = chrysanthemums * 3.75 + roses * 4.5 + tulips * 4.15;
                    break;
            }

            if (isHoliday == "Y")
            {
                price *= (1 + 15.0 / 100);
            }

            if (season == "Spring" && tulips > 7)
            {
                price *= (1 - 5.0 / 100);
            }
            if (season == "Winter" && roses >= 10)
            {
                price *= (1 - 10.0 / 100);
            }
            if (chrysanthemums + roses + tulips > 20)
            {
                price *= (1 - 20.0 / 100);
            }

            double finalPrice = price + 2;

            Console.WriteLine($"{finalPrice:f2}");

        }
    }
}
