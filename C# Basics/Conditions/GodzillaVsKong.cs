using System;

namespace GodzillaVsKong
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            int mutes = int.Parse(Console.ReadLine());
            double clothesPrice = double.Parse(Console.ReadLine());

            double decorePrice = budget * 10.0 / 100;
            double mutesExpense = mutes * clothesPrice;

            if (mutes > 150)
            {
                mutesExpense = mutesExpense * (1 - 10.0 / 100);
            }

            double totalExpense = decorePrice + mutesExpense;
            double finalBudget = budget - totalExpense;

            if (totalExpense > budget)
            {
                Console.WriteLine($"Not enough money!\nWingard needs {Math.Abs(finalBudget):f2} leva more.");
            }
            else
            {
                Console.WriteLine($"Action!\nWingard starts filming with {finalBudget:f2} leva left.");
            }
        }
    }
}