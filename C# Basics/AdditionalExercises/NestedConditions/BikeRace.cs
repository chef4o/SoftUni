using System;
using System.Runtime.InteropServices.ComTypes;
using System.Threading;

namespace BikeRace
{
    class Program
    {
        static void Main(string[] args)
        {

            int countJuniotr = int.Parse(Console.ReadLine());
            int countSenior = int.Parse(Console.ReadLine());
            string raceType = Console.ReadLine();

            double tax = 0;
            double expences = 0;

            switch (raceType)
            {
                case "trail":
                    tax = countJuniotr * 5.5 + countSenior * 7;
                    break;
                case "cross-country":
                    tax = countJuniotr * 8 + countSenior * 9.5;
                    if (countJuniotr + countSenior >= 50)
                    {
                        tax *= (1 - 25.0 / 100);
                    }
                    break;
                case "downhill":
                    tax = countJuniotr * 12.25 + countSenior * 13.75;
                    break;
                case "road":
                    tax = countJuniotr * 20 + countSenior * 21.50;
                    break;
            }

            expences = tax * 5.0 / 100;

            Console.WriteLine($"{(tax - expences):f2}");


        }
    }
}
