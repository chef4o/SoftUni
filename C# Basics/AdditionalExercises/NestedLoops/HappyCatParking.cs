using System;

namespace HappyCatParking
{
    class Program
    {
        static void Main(string[] args)
        {
            int days = int.Parse(Console.ReadLine());
            int hours = int.Parse(Console.ReadLine());

            double totalPrice = 0;

            for (int d = 1; d <= days; d++)
            {
                double dayPrice = 0;

                for (int h = 1; h <= hours ; h++)
                {
                    if (d % 2 == 0 && h % 2 != 0)
                    {
                        dayPrice += 2.5;
                    }
                    else if (d % 2 != 0 && h % 2 == 0)
                    {
                        dayPrice += 1.25;
                    }
                    else
                    {
                        dayPrice += 1;
                    }
                }

                Console.WriteLine($"Day: {d} - {dayPrice:f2} leva");
                totalPrice += dayPrice;
            }

            Console.WriteLine($"Total: {totalPrice:f2} leva");

        }
    }
}
