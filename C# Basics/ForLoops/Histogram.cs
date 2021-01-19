using System;

namespace Histogram
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int p1 = 0; // <200
            int p2 = 0; // >= 200 < 400
            int p3 = 0; // >= 400 < 600
            int p4 = 0; // >= 600 < 800 
            int p5 = 0; // >= 800

            for (int i = 0; i < n; i++)
            {
                int number = int.Parse(Console.ReadLine());

                if (number < 200)
                {
                    p1++;
                }
                else if (number >= 200 && number < 400)
                {
                    p2++;
                }
                else if (number >= 400 && number < 600)
                {
                    p3++;
                }
                else if (number >=600 && number < 800)
                {
                    p4++;
                }
                else if (number >= 800)
                {
                    p5++;
                }

            }

            Console.WriteLine($"{p1 / (n * 1.0) * 100:f2}%\n" +
                              $"{p2 / (n * 1.0) * 100:f2}%\n" +
                              $"{p3 / (n * 1.0) * 100:f2}%\n" +
                              $"{p4 / (n * 1.0) * 100:f2}%\n" +
                              $"{p5 / (n * 1.0) * 100:f2}%\n" );

        }
    }
}
