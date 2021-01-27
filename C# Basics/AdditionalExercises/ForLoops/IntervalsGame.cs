using System;

namespace IntervalsGame
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());

            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            int inv = 0;
            double score = 0;

            for (int i = 0; i < n; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (num >=0 && num <= 9)
                {
                    a++;
                    score += num * 20.0 / 100;
                }
                else if (num >= 10 && num <= 19)
                {
                    b++;
                    score += num * 30.0 / 100;
                }
                else if (num >= 20 && num <= 29)
                {
                    c++;
                    score += num * 40.0 / 100;
                }
                else if (num >= 30 && num <= 39)
                {
                    d++;
                    score += 50;
                }
                else if (num >= 40 && num <= 50)
                {
                    e++;
                    score += 100;
                }
                else
                {
                    inv++;
                    score /= 2.0;
                }

            }

            Console.WriteLine($"{score:f2}\n" +
                              $"From 0 to 9: {(a * 1.0) / (n * 1.0) * 100:f2}%\n" + 
                              $"From 10 to 19: {(b * 1.0) / (n * 1.0) * 100:f2}%\n" + 
                              $"From 20 to 29: {(c * 1.0) / (n * 1.0) * 100:f2}%\n" + 
                              $"From 30 to 39: {(d * 1.0) / (n * 1.0) * 100:f2}%\n" + 
                              $"From 40 to 50: {(e * 1.0) / (n * 1.0) * 100:f2}%\n" + 
                              $"Invalid numbers: {(inv * 1.0) / (n * 1.0) * 100:f2}%");

        }
    }
}
