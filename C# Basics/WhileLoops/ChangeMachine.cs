using System;

namespace ChangeMachine
{
    class Program
    {
        static void Main(string[] args)
        {
            double change = double.Parse(Console.ReadLine());

            double coinChange = Math.Floor(change * 100.0);

            double coinsCount = 0;

            while (coinChange > 0)
            {
                if (coinChange >= 200)
                {
                    coinChange -= 200;
                }
                else if (coinChange >= 100)
                {
                    coinChange -= 100;
                }
                else if (coinChange >= 50)
                {
                    coinChange -= 50;
                }
                else if (coinChange >= 20)
                {
                    coinChange -= 20;
                }
                else if (coinChange >= 10)
                {
                    coinChange -= 10;
                }
                else if (coinChange >= 5)
                {
                    coinChange -= 5;
                }
                else if (coinChange >= 2)
                {
                    coinChange -= 2;
                }
                else if (coinChange >= 1)
                {
                    coinChange -= 1;
                }

                coinsCount++;

            }

            Console.WriteLine(coinsCount);
        }
    }
}
