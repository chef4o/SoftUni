using System;

namespace SwimmingREcord
{
    class Program
    {
        static void Main(string[] args)
        {
            double currentRecord = double.Parse(Console.ReadLine());
            double distance = double.Parse(Console.ReadLine());
            double oneMemerScore = double.Parse(Console.ReadLine());

            double distanceScore = oneMemerScore * distance;
            double delay = Math.Floor(distance / 15) * 12.5;
            double finalScore = distanceScore + delay;

            if (finalScore >= currentRecord)
            {
                Console.WriteLine($"No, he failed! He was {(finalScore-currentRecord):f2} seconds slower.");
            }
            else
            {
                Console.WriteLine($"Yes, he succeeded! The new world record is {finalScore:f2} seconds.");
            }
        }
    }
}
