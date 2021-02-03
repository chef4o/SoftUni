using System;

namespace DebuggingHolidays
{
    class Program
    {
        static void Main()
        {
            DateTime startDate = DateTime.Parse(Console.ReadLine());
            DateTime endDate = DateTime.Parse(Console.ReadLine());

            int holidaysCount = 0;

            for (DateTime date = startDate; date <= endDate; date = date.AddDays(1))
            {
                if (date.DayOfWeek == DayOfWeek.Saturday ||
                    date.DayOfWeek == DayOfWeek.Sunday)

                {
                    holidaysCount++;
                }
            }

            Console.WriteLine(holidaysCount);
        }
    }
}
