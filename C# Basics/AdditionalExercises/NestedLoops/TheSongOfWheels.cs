using System;
using System.Diagnostics.Tracing;

namespace TheSongOfWheels
{
    class Program
    {
        static void Main(string[] args)
        {
            int m = int.Parse(Console.ReadLine());

            int counter = 0;
            string fourthWheel = string.Empty;
            string output = string.Empty;

            for (int a = 1; a <= 9; a++)
            {
                for (int b = 1; b <= 9; b++)
                {
                    for (int c = 1; c <= 9; c++)
                    {
                        for (int d = 1; d <= 9; d++)
                        {
                            if (a < b && 
                                c > d && 
                               (a*b + c*d) == m)
                            {
                                counter++;
                                if (counter == 1)
                                {
                                    Console.Write($"{a}{b}{c}{d}");
                                }
                                else
                                {
                                    Console.Write($" {a}{b}{c}{d}");
                                    if (counter == 4)
                                    {
                                        fourthWheel = $"{a}{b}{c}{d}";
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (counter < 4)
            {
                output = "\nNo!";
            }
            else
            {
                output = $"\nPassword: {fourthWheel}";
            }

            Console.WriteLine(output);

        }
    }
}
