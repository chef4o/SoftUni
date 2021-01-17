using System;
using System.Runtime.ExceptionServices;

namespace FishingBoat
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();
            int fishermen = int.Parse(Console.ReadLine());

            double boatPrice = 0;

            switch (season)
            {
                case "Spring":
                    boatPrice = 3000;
                    break;
                case "Summer":
                case "Autumn":
                    boatPrice = 4200;
                    break;
                case "Winter":
                    boatPrice = 2600;
                    break;
            }

                if (fishermen <= 6)
                {
                    boatPrice *= (1 - 10.0 / 100);
                }
                else if (fishermen >= 7 && fishermen <= 11)
                {
                    boatPrice *= (1 - 15.0 / 100);
                }
                else if (fishermen >= 12)
                {
                    boatPrice *= (1 - 25.0 / 100);
                }

            if ((season == "Spring" || season == "Summer" || season == "Winter") && fishermen % 2 == 0)
            {
                boatPrice *= (1 - 5.0 / 100);
            }

            double difference = budget - boatPrice;
            string output = string.Empty;

            if (budget >= boatPrice)
            {
                output = $"Yes! You have {difference:f2} leva left.";
            }
            else
            {
                output = $"Not enough money! You need {Math.Abs(difference):f2} leva.";
            }

            Console.WriteLine(output);
        }
    }
}
