using System;

namespace CenturyToMinutes
{
    class Program
    {
        static void Main(string[] args)
        {
            short centuries = short.Parse(Console.ReadLine());
            uint years = (uint)centuries * 100;
            uint days = (uint)(years * 365.2422);
            uint hours = days * 24;
            ulong minutes = hours * 60;

            Console.WriteLine($"{centuries} centuries = {years} years = {days} days = {hours} hours = {minutes} minutes");
        }
    }
}
