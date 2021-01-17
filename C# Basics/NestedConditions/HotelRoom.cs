using System;
using System.Diagnostics.CodeAnalysis;

namespace HotelRoom
{
    class Program
    {
        static void Main(string[] args)
        {
            string month = Console.ReadLine();
            int nights = int.Parse(Console.ReadLine());

            double studioPrice = 0;
            double apartmentPrice = 0;

            switch (month)
            {
                case "May":
                case "October":
                    studioPrice = 50 * nights;
                    apartmentPrice = 65 * nights;
                    if (nights > 7 && nights <= 14)
                    {
                        studioPrice *= (1 - 5.0 / 100);
                    }
                    else if (nights > 14)
                    {
                        studioPrice *= (1 - 30.0 / 100);
                        apartmentPrice *= (1 - 10.0 / 100);
                    }
                    break;
                case "June":
                case "September":
                    studioPrice = 75.2 * nights;
                    apartmentPrice = 68.7 * nights;
                    if (nights > 14)
                    {
                        studioPrice *= (1 - 20.0 / 100);
                        apartmentPrice *= (1 - 10.0 / 100);
                    }
                    break;
                case "July":
                case "August":
                    studioPrice = 76 * nights;
                    apartmentPrice = 77 * nights;
                    if (nights > 14)
                    {
                        apartmentPrice *= (1 - 10.0 / 100);
                    }
                    break;
            }

            Console.WriteLine($"Apartment: {apartmentPrice:f2} lv.\nStudio: {studioPrice:f2} lv.");

        }
    }
}
