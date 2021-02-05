using System;

namespace Vacation
{
    class Program
    {
        static void Main(string[] args)
        {
            int group = int.Parse(Console.ReadLine());
            string type = Console.ReadLine().ToLower();
            string day = Console.ReadLine().ToLower();

            double price = 0;
            double discount = 0;

            if (type == "students")
            {
                if (day == "friday")
                {
                    price = 8.45;
                }
                else if (day == "saturday")
                {
                    price = 9.80;
                }
                else if (day == "sunday")
                {
                    price = 10.46;
                }

                if (group >= 30)
                {
                    discount = 0.15 * group * price;
                }

                if (type == "regular")
                {
                    if (day == "friday")
                    {
                        price = 15;
                    }
                    else if (day == "saturday")
                    {
                        price = 20;
                    }
                    else if (day == "sunday")
                    {
                        price = 22.5;
                    }

                    if (group >= 10 && group <= 20)
                    {
                        discount = 0.05 * group * price;
                    }
                }

                if (type == "business")
                {
                    if (day == "friday")
                    {
                        price = 10.90;
                    }
                    else if (day == "saturday")
                    {
                        price = 15.60;
                    }
                    else if (day == "sunday")
                    {
                        price = 16;
                    }

                    if (group >= 100)
                    {
                        discount = 10 * price;
                    }
                }

                double totalPrice = (group * price) - discount;

                Console.WriteLine($"Total price: {totalPrice:F2}");
            }
        }
    }
}