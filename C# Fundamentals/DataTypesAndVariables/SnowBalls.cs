using System;
using System.Numerics;

namespace SnowBalls
{
    class Program
    {
        static void Main(string[] args)
        {
            byte n = byte.Parse(Console.ReadLine());

            short bestSnow = 0;
            short bestTime = 0;
            byte bestQuality = 0;
            BigInteger bestValue = 0;

            for (int i = 0; i < n; i++)
            {
                short snow = short.Parse(Console.ReadLine());
                short time = short.Parse(Console.ReadLine());
                byte quality = byte.Parse(Console.ReadLine());

                BigInteger value = BigInteger.Pow(snow / time, quality);

                if (value > bestValue)
                {
                    bestSnow = snow;
                    bestTime = time;
                    bestQuality = quality;
                    bestValue = value;
                }
            }

            Console.WriteLine($"{bestSnow} : {bestTime} = {bestValue} ({bestQuality})");
        }
    }
}
