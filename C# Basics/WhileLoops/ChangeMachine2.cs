using System;

namespace ChangeMachine2
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
                if (coinChange < 200)
                {
                    if (coinChange < 100)
                    {
                        if (coinsCount < 50)
                        {
                            if (coinsCount < 20)
                            {
                                if (coinsCount < 10)
                                {
                                    if (coinsCount < 5)
                                    {
                                        if (coinsCount < 2)
                                        {
                                            if (coinsCount == 1)
                                            {
                                                coinChange -= 1;
                                            }
                                            coinChange -= 2;
                                        }
                                        coinChange -= 5;
                                    }
                                    coinChange -= 10;
                                }
                                coinChange -= 20;
                            }
                            coinChange -= 50;
                        }
                        coinChange -= 100;
                    }
                    coinChange -= 200;
                }

                coinsCount++;

            }

            Console.WriteLine(coinsCount);
        }
    }
}
