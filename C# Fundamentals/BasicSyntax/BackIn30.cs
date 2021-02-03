using System;

namespace BackIn30
{
    class Program
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            int min = int.Parse(Console.ReadLine()) + 30;

            if (min >= 60)
            {
                min -= 60;
                hour++;
            }
            if (hour >= 24)
            {
                hour -= 24;
            }

            Console.WriteLine($"{hour}:{min:D2}");
        }
    }
}
