using System;
using System.Reflection;

namespace Logistic
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int busLoad = 0;
            int truckLoad = 0;
            int trainLoad = 0;

            for (int i = 0; i < n; i++)
            {
                int tons = int.Parse(Console.ReadLine());

                if (tons <= 3)
                {
                    busLoad += tons;
                }
                else if (tons >= 4 && tons <= 11)
                {
                    truckLoad += tons;
                }
                else
                {
                    trainLoad += tons;
                }

            }

            int totalLoad = busLoad + truckLoad + trainLoad;
            int bussPrice = busLoad * 200;
            int truckPrice = truckLoad * 175;
            int trainPrice = trainLoad * 120;
            double avgPrice = (bussPrice + truckPrice + trainPrice) / (totalLoad * 1.0);

            Console.WriteLine($"{avgPrice:f2}\n" +
                              $"{((1.0 * busLoad) / (1.0 * totalLoad) * 100):f2}%\n" +
                              $"{((1.0 * truckLoad) / (1.0 * totalLoad) * 100):f2}%\n" +
                              $"{((1.0 * trainLoad) / (1.0 * totalLoad) * 100):f2}%");

        }
    }
}
