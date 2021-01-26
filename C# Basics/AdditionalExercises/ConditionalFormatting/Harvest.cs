using System;

namespace Harvest
{
    class Program
    {
        static void Main(string[] args)
        {
            double vineyardArea = double.Parse(Console.ReadLine());
            double grapePerSqM = double.Parse(Console.ReadLine());
            double vineTarget = double.Parse(Console.ReadLine());
            int workers = int.Parse(Console.ReadLine());

            double grapeForVineProduction = vineyardArea * grapePerSqM * 40 / 100;
            double vineProduction = grapeForVineProduction / 2.5;
            double vineDifference = Math.Abs(vineTarget - vineProduction);
            double happyWorkers = vineDifference / workers;

            if (vineProduction < vineTarget)
            {
                Console.WriteLine($"It will be a tough winter! More {Math.Floor(vineDifference)} liters wine needed.");
            }
            else
            {
                Console.WriteLine($"Good harvest this year! Total wine: {Math.Floor(vineProduction)} liters.\n{Math.Ceiling(vineDifference)} liters left -> {Math.Ceiling(happyWorkers)} liters per person.");
            }

        }
    }
}
