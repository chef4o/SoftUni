using System;

namespace FishTank
{
    class Program
    {
        static void Main(string[] args)
        {
            int hight = int.Parse(Console.ReadLine());
            int lenght = int.Parse(Console.ReadLine());
            int width = int.Parse(Console.ReadLine());
            double percentStuff = double.Parse(Console.ReadLine());

            double capacity = hight * lenght * width;
            double liters = capacity * 0.001;

            double volume = liters - (liters * percentStuff / 100);
            Console.WriteLine(volume);

        }
    }
}
