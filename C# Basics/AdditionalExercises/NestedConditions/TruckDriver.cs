using System;

namespace TruckDriver
{
    class Program
    {
        static void Main(string[] args)
        {
            string season = Console.ReadLine();
            double mileage = double.Parse(Console.ReadLine());

            double wage = 0;

            switch (season)
            {
                case "Spring":
                case "Autumn":
                    if (mileage <= 5000)
                    {
                        wage = mileage * 0.75;
                    }
                    else if (mileage > 5000 && mileage <= 10000)
                    {
                        wage = mileage * 0.95;
                    }
                    else if (mileage > 10000 && mileage <= 20000)
                    {
                        wage = mileage * 1.45;
                    }
                    break;
                case "Summer":
                    if (mileage <= 5000)
                    {
                        wage = mileage * 0.9;
                    }
                    else if (mileage > 5000 && mileage <= 10000)
                    {
                        wage = mileage * 1.1;
                    }
                    else if (mileage > 10000 && mileage <= 20000)
                    {
                        wage = mileage * 1.45;
                    }
                    break;
                case "Winter":
                    if (mileage <= 5000)
                    {
                        wage = mileage * 1.05;
                    }
                    else if (mileage > 5000 && mileage <= 10000)
                    {
                        wage = mileage * 1.25;
                    }
                    else if (mileage > 10000 && mileage <= 20000)
                    {
                        wage = mileage * 1.45;
                    }
                    break;             
            }

            wage *= 4;

            double finalWage = wage * (1 - 10.0 / 100);

            Console.WriteLine($"{finalWage:f2}");
        }
    }
}
