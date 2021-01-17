using System;

namespace Voleyball
{
    class Program
    {
        static void Main(string[] args)
        {
            string year = Console.ReadLine();
            int weekDayHolidays = int.Parse(Console.ReadLine());
            int hometownWeekends = int.Parse(Console.ReadLine());

            double sofiaGames = (48 - hometownWeekends) * 3.0 / 4;
            double holidayGames = weekDayHolidays * 2.0 / 3;

            double games = sofiaGames + holidayGames + hometownWeekends;

            if (year == "leap")
            {
                games *= (1 + 15.0 / 100);
            }

            Console.WriteLine(Math.Floor(games));

        }
    }
}
