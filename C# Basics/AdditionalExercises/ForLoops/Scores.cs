using System;

namespace Scores
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            double top = 0;
            double veryGood = 0;
            double good = 0;
            double fail = 0;
            double totalscore = 0;

            for (int i = 0; i < n; i++)
            {

                double score = double.Parse(Console.ReadLine());
                totalscore += score;

                if (score >= 5)
                {
                    top++;
                }
                else if (score < 5 && score >= 4)
                {
                    veryGood++;
                }
                else if (score < 4 && score >= 3)
                {
                    good++;
                }
                else if (score <3)
                {
                    fail++;
                }

            }

            Console.WriteLine($"Top students: {(top * 1.0) / (n * 1.0) * 100:f2}%\n" +
                              $"Between 4.00 and 4.99: {(veryGood * 1.0) / (n * 1.0) * 100:f2}%\n" +
                              $"Between 3.00 and 3.99: {(good * 1.0) / (n * 1.0) * 100:f2}%\n" +
                              $"Fail: {(fail * 1.0) / (n * 1.0) * 100:f2}%\n" +
                              $"Average: {(totalscore * 1.0) / n:f2}");

        }
    }
}
