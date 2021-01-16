using System;

namespace SkiTrip
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            string roomType = Console.ReadLine();
            string feedback = Console.ReadLine();

            int nights = days - 1;
            double finalPrice = 0;

            switch (roomType)
            {
                case "room for one person":
                    finalPrice = nights * 18;
                    break;
                case "apartment":
                    if (days < 10)
                    {
                        finalPrice = (nights * 25) * (1 - 30.0 / 100);
                    }
                    else if (days >= 10 && days <=15)
                    {
                        finalPrice = (nights * 25) * (1 - 35.0 / 100);
                    }
                    else if (days > 15)
                    { 
                        finalPrice = (nights * 25) * (1 - 50.0 / 100);
                    }
                    break;
                case "president apartment":
                    if (days < 10)
                    {
                        finalPrice = (nights * 35) * (1 - 10.0 / 100);
                    }
                    else if (days >= 10 && days <= 15)
                    {
                        finalPrice = (nights * 35) * (1 - 15.0 / 100);
                    }
                    else if (days > 15)
                    {
                        finalPrice = (nights * 35) * (1 - 20.0 / 100);
                    }
                    break;
            }

            if (feedback == "positive")
            {
                finalPrice *= (1 + 25.0 / 100);
            }
            else if (feedback == "negative")
            {
                finalPrice *= (1 - 10.0 / 100);
            }
            Console.WriteLine($"{finalPrice:f2}");
        }
    }
}
