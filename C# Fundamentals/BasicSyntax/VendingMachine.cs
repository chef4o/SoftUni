using System;

namespace VendingMachine
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine().ToLower();

            double cash = 0;
            while (input != "start")
            {
                if (Convert.ToDouble(input) == 0.1 || 
                    Convert.ToDouble(input) == 0.2 || 
                    Convert.ToDouble(input) == 0.5 || 
                    Convert.ToDouble(input) == 1.0 || 
                    Convert.ToDouble(input) == 2.0)
                {
                    cash += Convert.ToDouble(input);
                }
                else
                {
                    Console.WriteLine($"Cannot accept {input}");
                }

                input = Console.ReadLine().ToLower();
            }

            input = Console.ReadLine().ToLower();

            double cost = 0;
            double totalCost = 0;
            while (input != "end")
            {
                switch (input)
                {
                    case "nuts":
                        cost = 2;
                        break;
                    case "water":
                        cost = 0.7;
                        break;
                    case "crisps":
                        cost = 1.5;
                        break;
                    case "soda":
                        cost = 0.8;
                        break;
                    case "coke":
                        cost = 1;
                        break;
                    default:
                        Console.WriteLine("Invalid product");
                        input = Console.ReadLine().ToLower();
                        continue;
                }

                if (cost + totalCost <= cash)
                {
                    Console.WriteLine($"Purchased {input}");
                    totalCost += cost;
                }
                else if (cost + totalCost > cash)
                {
                    Console.WriteLine("Sorry, not enough money");
                }

                input = Console.ReadLine().ToLower();
            }

            Console.WriteLine($"Change: {cash - totalCost:f2}");
        }
    }
}
