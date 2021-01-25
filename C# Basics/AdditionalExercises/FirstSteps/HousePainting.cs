using System;

namespace HousePainting
{
    class Program
    {
        static void Main(string[] args)
        {
            double x = double.Parse(Console.ReadLine());
            double y = double.Parse(Console.ReadLine());
            double h = double.Parse(Console.ReadLine());

            double doorArea = 1.2 * 2;
            double windowArea = 1.5 * 1.5;
            double frontWallsArea = 2 * (x * x) - doorArea;
            double sideWallsArea = 2 * (x * y) - 2 * windowArea;
            double roofTopArea = 2 * (x * y) + 2 * (x * h / 2);

            double greenPaint = (frontWallsArea + sideWallsArea) / 3.4;
            double redPaint = roofTopArea / 4.3;

            Console.WriteLine($"{greenPaint:f2}");
            Console.WriteLine($"{redPaint:f2}");


        }
    }
}
