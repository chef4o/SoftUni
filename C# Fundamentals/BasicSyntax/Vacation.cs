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

            switch (type)
            {
                case "students":
                    switch (day)
                    {
                        case "friday":
                            price = 8.45;
                            break;

                        case "saturday":
                            price = 9.80;
                            break;

                        case "sunday":
                            price = 10.46;
                            break;
                    }
                    break;

                case "business":

                    if (group >= 100)
                    {
                        group -= 10;
                    }

                    switch (day)
                    {
                        case "friday":
                            price = 10.90;
                            break;

                        case "saturday":
                            price = 15.60;
                            break;

                        case "sunday":
                            price = 16;
                            break;
                    }
                    break;

                case "regular":
                    switch (day)
                    {
                        case "friday":
                            price = 15;
                            break;

                        case "saturday":
                            price = 20;
                            break;

                        case "sunday":
                            price = 22.5;
                            break;
                    }
                    break;
            }

            double totalPrice = group * price;
            if (type == "students" && group >= 30)
            {
                totalPrice *=  (1 - 15 / 100.0);
            }
            if (type == "regular" && group >= 10 && group <= 20)
            {
                totalPrice *= (1 - 5 / 100.0);
            }

            Console.WriteLine($"Total price: {totalPrice:f2}");
        }
    }
}
