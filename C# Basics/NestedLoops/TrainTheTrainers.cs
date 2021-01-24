using System;

namespace TrainTheTrainers
{
    class Program
    {
        static void Main(string[] args)
        {
            int examiners = int.Parse(Console.ReadLine());

            double finalScore = 0;
            double totalScores = 0;

            while (true)
            {
                string input = Console.ReadLine();
                if (input == "Finish")
                {
                    break;
                }

                string exam = input;
                double examScore = 0;

                for (int i = 0; i < examiners; i++)
                {
                    double score = double.Parse(Console.ReadLine());
                    examScore += score;
                    totalScores++;
                }

                Console.WriteLine($"{exam} - {examScore * 1.0 / examiners:f2}.");
                finalScore += examScore;
            }

            Console.WriteLine($"Student's final assessment is {finalScore * 1.0 / totalScores:f2}.");

        }
    }
}
