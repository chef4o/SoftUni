using System;

namespace VacationBooking
{
    class Program
    {
        static void Main(string[] args)
        {
            int pagesCount = int.Parse(Console.ReadLine());
            double pagesPerHour = double.Parse(Console.ReadLine());
            int daysToComplete = int.Parse(Console.ReadLine());

            double TimeToFinish = pagesCount / pagesPerHour;
            double HoursPerDayToFinish = TimeToFinish / daysToComplete;
            Console.WriteLine(HoursPerDayToFinish);
        }
    }
}
