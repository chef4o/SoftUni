using System;

namespace Graduation
{
    class Program
    {
        static void Main(string[] args)
        {
            string studentName = Console.ReadLine();

            int grade = 1;
            double totalScore = 0;
            int fail = 0;
            string output = string.Empty;

            while (true)
            {
                double score = double.Parse(Console.ReadLine());

                if (score >= 4)
                {
                    grade++;
                    totalScore += score;
                }
                else
                {
                    fail++;
                    if (fail == 2)
                    {
                        output = $"{studentName} has been excluded at {grade} grade";
                        break;
                    }
                }

                if (grade > 12)
                {
                    output = $"{studentName} graduated. Average grade: {totalScore / 12:f2}";
                    break;
                }

            }

            Console.WriteLine(output);

        }
    }
}
