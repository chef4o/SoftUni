using System;

namespace SchoolCamp
{
    class Program
    {
        static void Main(string[] args)
        {
            string season = Console.ReadLine();
            string groupType = Console.ReadLine();
            int students = int.Parse(Console.ReadLine());
            int nights = int.Parse(Console.ReadLine());

            string sport = string.Empty;
            double price = 0;

            switch (season)
            {
                case "Winter":
                    switch (groupType)
                    {
                        case "girls":
                            price = students * nights * 9.6;
                            sport = "Gymnastics";
                            break;
                        case "boys":
                            price = students * nights * 9.6;
                            sport = "Judo";
                            break;
                        case "mixed":
                            price = students * nights * 10;
                            sport = "Ski";
                            break;
                    }
                    break;
                case "Spring":
                    switch (groupType)
                    {
                        case "girls":
                            price = students * nights * 7.2;
                            sport = "Athletics";
                            break;
                        case "boys":
                            price = students * nights * 7.2;
                            sport = "Tennis";
                            break;
                        case "mixed":
                            price = students * nights * 9.5;
                            sport = "Cycling";
                            break;
                    }
                    break;
                case "Summer":
                    switch (groupType)
                    {
                        case "girls":
                            price = students * nights * 15;
                            sport = "Volleyball";
                            break;
                        case "boys":
                            price = students * nights * 15;
                            sport = "Football";
                            break;
                        case "mixed":
                            price = students * nights * 20;
                            sport = "Swimming";
                            break;
                    }
                    break;
            }

            if (students >= 50)
            {
                price *= (1 - 50.0 / 100);
            }
            else if (students < 50 && students >= 20)
            {
                price *= (1 - 15.0 / 100);
            }
            else if (students >= 10 && students < 20)
            {
                price *= (1 - 5.0 / 100);
            }

            Console.WriteLine($"{sport} {price:f2} lv.");
        }
    }
}
