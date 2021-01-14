using System;

namespace SpeedInfo
{
    class Program
    {
        static void Main(string[] args)
        {
            double speed = double.Parse(Console.ReadLine());

            string speedLabel = String.Empty;

            if (speed <= 10)
            {
                speedLabel = "slow";
            }
            else if (speed <= 50)
            {
                speedLabel = "average";
            }
            else if (speed <= 150)
            {
                speedLabel = "fast";
            }
            else if (speed <= 1000)
            {
                speedLabel = "ultra fast";
            }
            else
            {
                speedLabel = "extremely fast";
            }

            Console.WriteLine(speedLabel);

        }
    }
}
