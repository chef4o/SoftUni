using System;

namespace RageExpenses
{
    class Program
    {
        static void Main(string[] args)
        {
            int lostGames = int.Parse(Console.ReadLine());
            double headsetPrice = double.Parse(Console.ReadLine());
            double mousePrice = double.Parse(Console.ReadLine());
            double keyboardPrice = double.Parse(Console.ReadLine());
            double displayPrice = double.Parse(Console.ReadLine());

            double rageExpenses = headsetPrice * (lostGames / 2);
            rageExpenses += mousePrice * (lostGames / 3);
            rageExpenses += keyboardPrice * (lostGames / 6);
            rageExpenses += displayPrice * (lostGames / 12);

            Console.WriteLine($"Rage expenses: {rageExpenses:f2} lv.");
        }
    }
}
