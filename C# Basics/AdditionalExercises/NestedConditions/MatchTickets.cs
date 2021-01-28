using System;

namespace AdvancedNested
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string category = Console.ReadLine();
            int people = int.Parse(Console.ReadLine());

            double transportation = 0;
            double price = 0;
            string output = string.Empty;

            switch (category)
            {
                case "VIP":
                    price = 499.99 * people;
                    break;
                case "Normal":
                    price = 249.99 * people;
                    break;
            }

            if (people >= 1 && people < 5)
            {
                transportation = budget * 75.0 / 100;
            }
            else if (people >= 5 && people < 10 )
            {
                transportation = budget * 60.0 / 100;
            }
            else if (people >= 10 && people < 25)
            {
                transportation = budget * 50.0 / 100;
            }
            else if (people >= 25 && people < 50)
            {
                transportation = budget * 40.0 / 100;
            }
            else if (people >=50)
            {
                transportation = budget * 25.0 / 100;
            }

            if (budget - transportation >= price)
            {
                output = $"Yes! You have {(budget - transportation - price):f2} leva left.";
            }
            else
            {
                output = $"Not enough money! You need {Math.Abs(budget - transportation - price):f2} leva.";
            }

            Console.WriteLine(output);

        }
    }
}
