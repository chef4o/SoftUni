using System;
using System.Transactions;

namespace ToyShop
{
    class Program
    {
        static void Main(string[] args)
        {
            double TripPrice = double.Parse(Console.ReadLine());
            int puzzleCount = int.Parse(Console.ReadLine());
            int dollCount = int.Parse(Console.ReadLine());
            int bearCount = int.Parse(Console.ReadLine());
            int minionCount = int.Parse(Console.ReadLine());
            int truckCount = int.Parse(Console.ReadLine());

            double puzzlePrice = puzzleCount * 2.6;
            double dollPrice = dollCount * 3;
            double bearPrice = bearCount * 4.1;
            double minionPrice = minionCount * 8.2;
            double truckPrice = truckCount * 2;

            double totalCount = puzzleCount + dollCount + bearCount + minionCount + truckCount;
            double totalPrice = puzzlePrice + dollPrice + bearPrice + minionPrice + truckPrice;

            if (totalCount >= 50)
            {
                totalPrice = totalPrice - (totalPrice * 25 / 100);
            }

            double profit = totalPrice - (totalPrice * 10 / 100);

            if (profit >= TripPrice)
            {
                double leftover = profit - TripPrice;
                Console.WriteLine($"Yes! {leftover:f2} lv left.");
            }
            else
            {
                double leftover = TripPrice - profit;
                Console.WriteLine($"Not enough money! {leftover:f2} lv needed.");
            }
        }
    }
}
