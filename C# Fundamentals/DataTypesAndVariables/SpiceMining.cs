using System;

namespace SpiceMining
{
    class Program
    {
        static void Main(string[] args)
        {
            int yield = int.Parse(Console.ReadLine());

            int operationDays = 0;
            int totalSpice = 0;

            while (yield >= 100)
            {
                totalSpice += yield - 26;
                yield -= 10;
                operationDays++;
            }

            if (totalSpice > 26)
            {
                totalSpice -= 26;
            }

            Console.WriteLine($"{operationDays}\n{totalSpice}");
        }
    }
}
