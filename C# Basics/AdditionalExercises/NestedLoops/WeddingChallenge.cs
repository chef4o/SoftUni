using System;

namespace WeddingChallenge
{
    class Program
    {
        static void Main(string[] args)
        {
            int men = int.Parse(Console.ReadLine());
            int women = int.Parse(Console.ReadLine());
            int availableTables = int.Parse(Console.ReadLine());

            int busyTables = 0;
            bool spaceFull = false;

            for (int m = 1; m <= men; m++)
            {
                for (int f = 1; f <= women; f++)
                {
                    busyTables++;
                    if (busyTables > availableTables)
                    {
                        spaceFull = true;
                        break;
                    }

                    Console.Write($"({m} <-> {f}) ");

                }

                if (spaceFull)
                {
                    break;
                }
            }
        }
    }
}
