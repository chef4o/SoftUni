using System;
using System.Runtime.ConstrainedExecution;

namespace FuelTankExtended
{
    class Program
    {
        static void Main(string[] args)
        {
            string fuelType = Console.ReadLine();
            double liters = double.Parse(Console.ReadLine());
            string clubCard = Console.ReadLine();

            double gasolinePrice = liters * 2.22;
            double dieselPrice = liters * 2.33;
            double gasPrice = liters * 0.93;

            if (clubCard == "Yes")
            {
                gasolinePrice -= liters * 0.18;
                dieselPrice -= liters * 0.12;
                gasPrice -= liters * 0.08;
            }

            if (liters >= 20 && liters <=25)
            {
                gasolinePrice *= 1 - 8.0 / 100;
                dieselPrice *= 1 - 8.0 / 100;
                gasPrice *= 1 - 8.0 / 100;
            }
            else if (liters > 25)
            {
                gasolinePrice *= 1 - 10.0 / 100;
                dieselPrice *= 1 - 10.0 / 100;
                gasPrice *= 1 - 10.0 / 100;
            }

            double finalPrice = 0;

            if (fuelType == "Diesel")
            {
                finalPrice = dieselPrice;
            }
            else if (fuelType == "Gasoline")
            {
                finalPrice = gasolinePrice;
            }
            else if (fuelType == "Gas")
            {
                finalPrice = gasPrice;
            }

            Console.WriteLine($"{finalPrice:f2} lv.");

        }
    }
}
