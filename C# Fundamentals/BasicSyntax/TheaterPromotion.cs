using System;

namespace TheaterPromotion
{
    class Program
    {
        static void Main(string[] args)
        {
            string day = Console.ReadLine().ToLower();
            int age = int.Parse(Console.ReadLine());

            int ticketPrice = 0;
            switch (day)
            {
                case "weekday":
                    if (age > 18 && age <= 64)
                    {
                        ticketPrice = 18;
                    }
                    else if ((age >= 0 && age <= 18) || (age > 64 && age <= 122))
                    {
                        ticketPrice = 12;
                    }
                    break;
                case "weekend":
                    if (age > 18 && age <= 64)
                    {
                        ticketPrice = 20;
                    }
                    else if ((age >= 0 && age <= 18) || (age > 64 && age <= 122))
                    {
                        ticketPrice = 15;
                    }
                    break;
                case "holiday":
                    if (age >= 0 && age <= 18)
                    {
                        ticketPrice = 5;
                    }
                    else if (age > 18 && age <= 64)
                    {
                        ticketPrice = 12;
                    }
                    else if (age > 64 && age <= 122)
                    {
                        ticketPrice = 10;
                    }
                    break;
                default:
                    Console.WriteLine("Error!");
                    break;
            }

            if (ticketPrice == 0)
            {
                Console.WriteLine("Error!");
            }
            else
            {
                Console.WriteLine($"{ticketPrice}$");
            }
        }
    }
}
