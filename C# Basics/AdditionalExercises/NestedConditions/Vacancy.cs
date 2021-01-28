using System;
using System.Data.Common;

namespace Vacancy
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();

            double price = 0;
            string location = string.Empty;
            string accomodation = string.Empty;

            switch (season)
            {
                case "Summer":
                    location = "Alaska";
                    if (budget <= 1000)
                    {
                        accomodation = "Camp";
                        price = budget * (65.0 / 100);
                    }
                    if (budget > 1000 && budget <= 3000)
                    {
                        accomodation = "Hut";
                        price = budget * (80.0 / 100);
                    }
                    if (budget > 3000)
                    {
                        accomodation = "Hotel";
                        price = budget * (90.0 / 100);
                    }
                    break;
                case "Winter":
                    location = "Morocco";
                    if (budget <= 1000)
                    {
                        accomodation = "Camp";
                        price = budget * (45.0 / 100);
                    }
                    if (budget > 1000 && budget <= 3000)
                    {
                        accomodation = "Hut";
                        price = budget * (60.0 / 100);
                    }
                    if (budget > 3000)
                    {
                        accomodation = "Hotel";
                        price = budget * (90.0 / 100);
                    }
                    break;
            }

            Console.WriteLine($"{location} - {accomodation} - {price:f2}");

        }
    }
}
