using System;
using System.Xml;

namespace TouristShop
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string item = Console.ReadLine();
            string output = string.Empty;

            int products = 0;
            double spendings = 0;
            int counter = 0;

            while (item != "Stop")
            {
                double price = double.Parse(Console.ReadLine());
                products++;
                counter++;

                if (counter == 3)
                {
                    price /= 2.0;
                    counter = 0;
                }
                spendings += price;

                if (budget < spendings)
                {
                    output = $"You don't have enough money!\nYou need {spendings - budget:f2} leva!";
                    break;
                }

                item = Console.ReadLine();
            }

            if (item == "Stop")
            {
                output = $"You bought {products} products for {spendings:f2} leva.";
            }
           
            Console.WriteLine(output);

        }
    }
}
