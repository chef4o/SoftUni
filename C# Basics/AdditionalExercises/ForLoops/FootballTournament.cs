using System;

namespace FootballTournament
{
    class Program
    {
        static void Main(string[] args)
        {
            int capacity = int.Parse(Console.ReadLine());
            int fens = int.Parse(Console.ReadLine());

            int a = 0;
            int b = 0;
            int v = 0;
            int g = 0;

            for (int i = 0; i < fens; i++)
            {

                string sector = Console.ReadLine();

                if (sector == "A")
                {
                    a++;
                }
                else if (sector == "B")
                {
                    b++;
                }
                else if (sector == "V")
                {
                    v++;
                }
                else if (sector == "G")
                {
                    g++;
                }

            }

            Console.WriteLine($"{a * 1.0 / fens * 1.0 * 100:f2}%\n" +
                              $"{b * 1.0 / fens * 1.0 * 100:f2}%\n" +
                              $"{v * 1.0 / fens * 1.0 * 100:f2}%\n" +
                              $"{g * 1.0 / fens * 1.0 * 100:f2}%\n" +
                              $"{(a + b + v + g) * 1.0 / capacity * 1.0 * 100:f2}%");

        }
    }
}
