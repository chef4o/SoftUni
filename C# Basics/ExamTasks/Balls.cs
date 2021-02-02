using System;

namespace Task4
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int redPoints = 0;
            int orangePoints = 0;
            int yellowPoints = 0;
            int whitePoints = 0;
            int blackCount = 0;
            int othersCount = 0;
            int totalPoints = 0;

            for (int i = 0; i < n; i++)
            {
                string input = Console.ReadLine();

                if (input == "red")
                {
                    redPoints++;
                    totalPoints += 5;
                }
                else if (input == "orange")
                {
                    orangePoints++;
                    totalPoints += 10;
                }
                else if (input == "yellow")
                {
                    yellowPoints++;
                    totalPoints += 15;
                }
                else if (input == "white")
                {
                    whitePoints++;
                    totalPoints += 20;
                }
                else if (input == "black")
                {
                    blackCount++;
                    totalPoints /= 2;
                }
                else
                {
                    othersCount++;
                }
            }

            Console.WriteLine($"Total points: {totalPoints}\n" +
                              $"Points from red balls: {redPoints}\n" +
                              $"Points from orange balls: {orangePoints}\n" +
                              $"Points from yellow balls: {yellowPoints}\n" +
                              $"Points from white balls: {whitePoints}\n" +
                              $"Other colors picked: {othersCount}\n" +
                              $"Divides from black balls: {blackCount}");
        }
    }
}
