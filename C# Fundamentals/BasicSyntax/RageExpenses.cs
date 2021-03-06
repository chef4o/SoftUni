﻿using System;

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

            double rageExpenses = 0;

            for (int game = 1; game <= lostGames; game++)
            {

                if (game % 2 == 0)
                {
                    rageExpenses += headsetPrice;
                }

                if (game % 3 == 0)
                {
                    rageExpenses += mousePrice;
                }

                if (game % 6 == 0)
                {
                    rageExpenses += keyboardPrice;
                }

                if (game % 12 == 0)
                {
                    rageExpenses += displayPrice;
                }
            }

            Console.WriteLine($"Rage expenses: {rageExpenses:f2} lv.");
        }
    }
}
