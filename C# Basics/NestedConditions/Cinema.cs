using System;

namespace Ex03_NestedConditions
{
    class Program
    {
        static void Main(string[] args)
        {
            string movieType = Console.ReadLine();
            int rows = int.Parse(Console.ReadLine());
            int columns = int.Parse(Console.ReadLine());

            double maxIncome = 0;

            switch (movieType)
            {
                case "Premiere":
                    maxIncome = rows * columns * 12;
                    break;
                case "Normal":
                    maxIncome = rows * columns * 7.5;
                    break;
                case "Discount":
                    maxIncome = rows * columns * 5;
                    break;
            }

            Console.WriteLine($"{maxIncome:f2}");

        }
    }
}
