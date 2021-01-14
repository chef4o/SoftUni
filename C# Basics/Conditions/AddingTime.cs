using System;

namespace AddingTime
{
    class Program
    {
        static void Main(string[] args)
        {
            int hour = int.Parse(Console.ReadLine());
            int min = int.Parse(Console.ReadLine());

            int newMin = min + 15;
            int newHour = hour;

            if (newMin > 59)
            {
                newMin = newMin % 60;
                newHour += 1;
            }
            if (newHour > 23)
            {
                newHour = newHour % 24;
            }

            if (newMin < 10)
            {
                Console.WriteLine($"{newHour}:0{newMin}");
            }
            else
            {
                Console.WriteLine($"{newHour}:{newMin}");
            }
        }
    }
}
