using System;

namespace FlowerShop
{
    class Program
    {
        static void Main(string[] args)
        {
            int magnoliaCount = int.Parse(Console.ReadLine());
            int hyacinthCount = int.Parse(Console.ReadLine());
            int rosesCount = int.Parse(Console.ReadLine());
            int cactusCount = int.Parse(Console.ReadLine());
            double presentPrice = double.Parse(Console.ReadLine());

            double flowersPrice = (magnoliaCount * 3.25) + (hyacinthCount * 4) + (rosesCount * 3.5) + (cactusCount * 8);
            double profit = flowersPrice * (1 - 5.0 / 100);
            double leftover = Math.Abs(presentPrice - profit);

            if (profit >= presentPrice)
            {
                Console.WriteLine($"She is left with {Math.Floor(leftover)} leva.");
            }
            else
            {
                Console.WriteLine($"She will have to borrow {Math.Ceiling(leftover)} leva.");
            }
        }
    }
}
