using System;

namespace MoreExercicesForCycle
{
    class Program
    {
        static void Main(string[] args)
        {
            double heritage = double.Parse(Console.ReadLine());
            int year = int.Parse(Console.ReadLine());

            double evenYearExpense = 0;
            double oddYearExpense = 0;
            int age = 18;
            string output = string.Empty;

            for (int i = 1800; i <= year; i++)
            {

                if (i % 2 == 0)
                {
                    evenYearExpense += 12000;
                }
                if (i % 2 != 0)
                {
                    oddYearExpense += 12000 + (50 * age);
                }

                age += 1;

            }

            if (evenYearExpense + oddYearExpense <= heritage)
            {
                output = $"Yes! He will live a carefree life and will have {(heritage - (evenYearExpense + oddYearExpense)):f2} dollars left.";
            }
            else
            {
                output = $"He will need {(Math.Abs(evenYearExpense + oddYearExpense - heritage)):f2} dollars to survive.";
            }

            Console.WriteLine(output);

        }
    }
}
