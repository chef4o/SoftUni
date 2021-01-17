using System;
using System.Diagnostics.CodeAnalysis;
using System.Diagnostics.Contracts;

namespace NewHome
{
    class Program
    {
        static void Main(string[] args)
        {
            string flower = Console.ReadLine();
            int count = int.Parse(Console.ReadLine());
            double budget = double.Parse(Console.ReadLine());

            double price = 0;

            switch (flower)
            {
                case "Roses":
                    price = count * 5;
                    if (count > 80)
                    {
                        price *= (1 - 10.0 / 100);
                    }*
                    break;
                case "Dahlias":
                    price = count * 3.8;
                    if (count > 90)
                    {
                        price *= (1 - 15.0 / 100);
                    }
                    break;
                case "Tulips":
                    price = count * 2.8;
                    if (count > 80)
                    {
                        price *= (1 - 15.0 / 100);
                    }
                    break;
                case "Narcissus":
                    price = count * 3;
                    if (count < 120)
                    {
                        price *= (1 + 15.0 / 100);
                    }
                    break;
                case "Gladiolus":
                    price = count * 2.5;
                    if (count < 80)
                    {
                        price *= (1 + 20.0 / 100);
                    }
                    break;
            }

            double leftOver = budget - price;
            string output = string.Empty;

            if (budget >= price)
            {
                output = $"Hey, you have a great garden with {count} {flower} and {leftOver:f2} leva left.";
            }
            else
            {
                output = $"Not enough money, you need {Math.Abs(leftOver):f2} leva more.";
            }

            Console.WriteLine(output);

        }
    }
}
