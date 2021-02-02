using System;

namespace SafariTrip
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            double fuel = double.Parse(Console.ReadLine());
            string weekDay = Console.ReadLine();

            double fuelPrice = fuel * 2.10;
            double guide = 100.00;
            double totalPrice = fuelPrice + guide;
            string output = string.Empty;

            switch (weekDay)
            {
                case "Saturday":
                    totalPrice *= (1 - 10.0 / 100);
                    break;
                case "Sunday":
                    totalPrice *= (1 - 20.0 / 100);
                    break;
            }

            if (totalPrice <= budget)
            {
                output = $"Safari time! Money left: {budget - totalPrice:f2} lv. ";
            }
            else
            {
                output = $"Not enough money! Money needed: {Math.Abs(budget - totalPrice):f2} lv.";
            }

            Console.WriteLine(output);

        }
    }
}
