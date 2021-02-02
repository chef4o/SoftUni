using System;

namespace VetParking
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());

            double totalTax = 0;

            for (int d = 1; d <= days; d++)
            {
                double tax = 0;

                for (int h = 1; h <= hours; h++)
                {
                    if (d % 2 == 0 && h % 2 != 0)
                    {
                        tax += 2.5;
                    }
                    else if (d % 2 != 0 && h % 2 == 0)
                    {
                        tax += 1.25;
                    }
                    else
                    {
                        tax += 1;
                    }
                }

                Console.WriteLine($"Day: {d} - {tax:f2} leva");
                totalTax += tax;
            }

            Console.WriteLine($"Total: {totalTax:f2} leva");

        }
    }
}
