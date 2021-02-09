using System;

namespace WaterOverflow
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int volume = 0;
            for (int i = 0; i < n; i++)
            {
                int stage = int.Parse(Console.ReadLine());

                if (volume + stage > 255)
                {
                    Console.WriteLine("Insufficient capacity!");
                }
                else
                {
                    volume += stage;
                }
            }

            Console.WriteLine(volume);
        }
    }
}
