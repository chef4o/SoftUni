using System;

namespace MobileOperator
{
    class Program
    {
        static void Main(string[] args)
        {
            string term = Console.ReadLine();
            string type = Console.ReadLine();
            string mobile = Console.ReadLine();
            int months = int.Parse(Console.ReadLine());

            double tax = 0;

            switch (type)
            {
                case "Small":
                    switch (term)
                    {
                        case "one":
                            tax = 9.98;
                            break;
                        case "two":
                            tax = 8.58;
                            break;
                    }
                    break;
                case "Middle":
                    switch (term)
                    {
                        case "one":
                            tax = 18.99;
                            break;
                        case "two":
                            tax = 17.09;
                            break;
                    }
                    break;
                case "Large":
                    switch (term)
                    {
                        case "one":
                            tax = 25.98;
                            break;
                        case "two":
                            tax = 23.59;
                            break;
                    }
                    break;
                case "ExtraLarge":
                    switch (term)
                    {
                        case "one":
                            tax = 35.99;
                            break;
                        case "two":
                            tax = 31.79;
                            break;
                    }
                    break;
            }

            if (mobile == "yes" && tax <= 10)
            {
                tax += 5.5;
            }
            else if (mobile == "yes" && tax <= 30)
            {
                tax += 4.35;
            }
            else if (mobile == "yes" && tax > 30)
            {
                tax += 3.85;
            }

            double totalPrice = tax * months;
            if (term == "two")
            {
                totalPrice *= (1 - 3.75 / 100);
            }

            Console.WriteLine($"{totalPrice:f2} lv.");

        }
    }
}
