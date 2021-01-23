using System;

namespace Travel
{
    class Program
    {
        static void Main(string[] args)
        {
            string destination = Console.ReadLine();

            while (destination != "End")
            {
                double budget = double.Parse(Console.ReadLine());

                double savings = 0;
                while (savings < budget)
                {
                    savings += double.Parse(Console.ReadLine());
                }

                Console.WriteLine($"Going to {destination}!");

                savings = 0;

                destination = Console.ReadLine();
            }
        }
    }
}
