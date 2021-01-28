using System;

namespace RentACar
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();

            string carType = string.Empty;
            string carClass = string.Empty;
            double carPrice = 0;

            switch (season)
            {
                case "Summer":
                    if (budget <= 100)
                    {
                        carClass = "Economy class";
                        carType = "Cabrio";
                        carPrice = budget * (35.0 / 100);
                    }
                    if (budget > 100 && budget <= 500)
                    {
                        carClass = "Compact class";
                        carType = "Cabrio";
                        carPrice = budget * (45.0 / 100);
                    }
                    if (budget > 500)
                    {
                        carClass = "Luxury class";
                        carType = "Jeep";
                        carPrice = budget * (90.0 / 100);
                    }
                    break;
                case "Winter":
                    if (budget <= 100)
                    {
                        carClass = "Economy class";
                        carType = "Jeep";
                        carPrice = budget * (65.0 / 100);
                    }
                    if (budget > 100 && budget <= 500)
                    {
                        carClass = "Compact class";
                        carType = "Jeep";
                        carPrice = budget * (80.0 / 100);
                    }
                    if (budget > 500)
                    {
                        carClass = "Luxury class";
                        carType = "Jeep";
                        carPrice = budget * (90.0 / 100);
                    }
                    break;
            }

            Console.WriteLine($"{carClass}\n{carType} - {carPrice:f2}");

        }
    }
}
