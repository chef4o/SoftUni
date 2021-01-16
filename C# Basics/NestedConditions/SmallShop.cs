using System;
using System.Xml;

namespace SmallShop
{
    class Program
    {
        static void Main(string[] args)
        {

            string item = Console.ReadLine();
            string town = Console.ReadLine();
            double quantity = double.Parse(Console.ReadLine());

            double price = 0;

            switch (town)
            {
                case "Sofia":
                    if (item == "coffee")
                    {
                        price = quantity * 0.5;
                    }
                    else if (item == "water")
                    {
                        price = quantity * 0.8;
                    }
                    else if (item == "beer")
                    {
                        price = quantity * 1.2;
                    }
                    else if (item == "sweets")
                    {
                        price = quantity * 1.45;
                    }
                    else if (item == "peanuts")
                    {
                        price = quantity * 1.6;
                    }
                    break;
                case "Plovdiv":
                    if (item == "coffee")
                    {
                        price = quantity * 0.4;
                    }
                    else if (item == "water")
                    {
                        price = quantity * 0.7;
                    }
                    else if (item == "beer")
                    {
                        price = quantity * 1.15;
                    }
                    else if (item == "sweets")
                    {
                        price = quantity * 1.30;
                    }
                    else if (item == "peanuts")
                    {
                        price = quantity * 1.5;
                    }
                    break;
                case "Varna":
                    if (item == "coffee")
                    {
                        price = quantity * 0.45;
                    }
                    else if (item == "water")
                    {
                        price = quantity * 0.7;
                    }
                    else if (item == "beer")
                    {
                        price = quantity * 1.10;
                    }
                    else if (item == "sweets")
                    {
                        price = quantity * 1.35;
                    }
                    else if (item == "peanuts")
                    {
                        price = quantity * 1.55;
                    }
                    break;
            }

            Console.WriteLine(price);

        }
    }
}
