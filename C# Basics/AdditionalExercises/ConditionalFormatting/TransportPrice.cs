using System;
using System.IO;

namespace TransportPrice
{
    class Program
    {
        static void Main(string[] args)
        {
            double distance = double.Parse(Console.ReadLine());
            string tarriff = Console.ReadLine();

            double taxiPrice = 0;
            double bussPrice = distance * 0.09;
            double trainPrice = distance * 0.06;

            if (tarriff == "day")
            {
                taxiPrice = distance * 0.79 + 0.7;
            }
            else if (tarriff == "night")
            {
                taxiPrice = distance * 0.9 + 0.7;
            }

            double topPrice = 0;

            if (distance < 20)
            {
                topPrice = taxiPrice;
            }
            else if (distance < 100)
            {
                if (bussPrice < taxiPrice)
                {
                    topPrice = bussPrice;
                }
                else
                {
                    topPrice = taxiPrice;
                }
            }
            else
            {
                if (bussPrice < taxiPrice && bussPrice < trainPrice)
                {
                    topPrice = bussPrice;
                }
                else if (trainPrice < taxiPrice && trainPrice < bussPrice)
                {
                    topPrice = trainPrice;
                }
                else
                {
                    topPrice = taxiPrice;   
                }
            }

            Console.WriteLine($"{topPrice:f2}");
        }
    }
}
