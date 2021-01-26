using System;

namespace TomCat
{
    class Program
    {
        static void Main(string[] args)
        {
            int restDays = int.Parse(Console.ReadLine());

            int weekDays = 365 - restDays;
            int playTime = weekDays * 63 + restDays * 127;
            int maxPlay = 30000;

            int timeDifference = Math.Abs(maxPlay - playTime);
            int h = timeDifference / 60;
            int m = timeDifference % 60;

            if (playTime > maxPlay)
            {
                Console.WriteLine($"Tom will run away\n{h} hours and {m} minutes more for play");
            }
            else
            {
                Console.WriteLine($"Tom sleeps well\n{h} hours and {m} minutes less for play");
            }

        }
    }
}
