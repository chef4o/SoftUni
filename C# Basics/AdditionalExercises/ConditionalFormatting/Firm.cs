using System;

namespace Firm
{
    class Program
    {
        static void Main(string[] args)
        {

            int hoursNeeded = int.Parse(Console.ReadLine());
            int availableDays = int.Parse(Console.ReadLine());
            int extraHourWorkers = int.Parse(Console.ReadLine());

            double hoursToWork = Math.Floor((availableDays * (1 - 10.0 / 100) * 8) + (extraHourWorkers * availableDays * 2));
            double offset = Math.Abs(hoursNeeded - hoursToWork);

            if (hoursToWork >= hoursNeeded)
            {
                Console.WriteLine($"Yes!{offset} hours left.");
            }
            else
            {
                Console.WriteLine($"Not enough time!{offset} hours needed.");
            }

        }
    }
}
