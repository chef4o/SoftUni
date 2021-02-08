using System;

namespace RefactorPyramidVolume
{
    class Program
    {
        static void Main(string[] args)
        {
            double lenght = double.Parse(Console.ReadLine());
            double width = double.Parse(Console.ReadLine());
            double hight = double.Parse(Console.ReadLine());
            double volume = (lenght * width * hight) / 3;

            Console.Write($"Length: Width: Height: Pyramid Volume: {volume:f2}");

        }
    }
}
