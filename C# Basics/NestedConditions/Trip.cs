using System;

namespace Trip
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            string season = Console.ReadLine();

            string destination = string.Empty;
            string shelter = string.Empty;
            double shelterPrice = 0;

            switch (season)
            {
                case "summer":
                    shelter = "Camp";
                    if (budget <= 100)
                    {
                        destination = "Bulgaria";
                        shelterPrice = budget * 30.0 / 100;
                    }
                    else if (budget > 100 && budget <= 1000)
                    {
                        destination = "Balkans";
                        shelterPrice = budget * 40.0 / 100;
                    }
                    else
                    {
                        shelter = "Hotel";
                        destination = "Europe";
                        shelterPrice = budget * 90.0 / 100;
                    }
                    break;
                case "winter":
                    shelter = "Hotel";
                    if (budget <= 100)
                    {
                        destination = "Bulgaria";
                        shelterPrice = budget * 70.0 / 100;
                    }
                    else if (budget > 100 && budget <= 1000)
                    {
                        destination = "Balkans";
                        shelterPrice = budget * 80.0 / 100;
                    }
                    else
                    {
                        destination = "Europe";
                        shelterPrice = budget * 90.0 / 100;
                    }
                    break;
            }

            Console.WriteLine($"Somewhere in {destination}\n{shelter} - {shelterPrice:f2}");
        }
    }
}
