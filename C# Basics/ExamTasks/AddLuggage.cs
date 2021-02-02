using System;

namespace AddLuggage
{
    class Program
    {
        static void Main(string[] args)
        {
            double luggagePricePer20kg = double.Parse(Console.ReadLine());
            double luggageWeight = double.Parse(Console.ReadLine());
            int daysToTrip = int.Parse(Console.ReadLine());
            int luggageCount = int.Parse(Console.ReadLine());

            double luggageTax = 0;

            if (luggageWeight < 10)
            {
                luggageTax = luggagePricePer20kg * 20.0 / 100;
            }
            else if (luggageWeight >= 10 && luggageWeight <= 20)
            {
                luggageTax = luggagePricePer20kg * 50.0 / 100;
            }
            else if (luggageWeight > 20)
            {
                luggageTax = luggagePricePer20kg;
            }

            if (daysToTrip > 30)
            {
                luggageTax *= (1 + 10.0 / 100);
            }
            else if (daysToTrip <= 30 && daysToTrip >= 7)
            {
                luggageTax *= (1 + 15.0 / 100);
            }
            else if (daysToTrip < 7)
            {
                luggageTax *= (1 + 40.0 / 100);
            }

            Console.WriteLine($"The total price of bags is: {luggageTax * luggageCount:f2} lv.");
        }
    }
}
