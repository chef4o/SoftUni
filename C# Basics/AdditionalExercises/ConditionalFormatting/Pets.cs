using System;

namespace Pets
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            double leftFoodKg = double.Parse(Console.ReadLine());
            double dogConsumption = double.Parse(Console.ReadLine());
            double catConsumption = double.Parse(Console.ReadLine());
            double turtleConsumption = double.Parse(Console.ReadLine());

            double consumedFood = (dogConsumption + catConsumption + (turtleConsumption / 1000)) * days;
            double leftover = Math.Abs(leftFoodKg - consumedFood);

            if (consumedFood <= leftFoodKg)
            {
                Console.WriteLine($"{Math.Floor(leftover)} kilos of food left.");
            }
            else
            {
                Console.WriteLine($"{Math.Ceiling(leftover)} more kilos of food are needed.");
            }

        }
    }
}
