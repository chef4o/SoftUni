using System;

namespace PointOnARectangular
{
    class Program
    {
        static void Main(string[] args)
        {
            double x1 = double.Parse(Console.ReadLine());
            double y1 = double.Parse(Console.ReadLine());
            double x2 = double.Parse(Console.ReadLine());
            double y2 = double.Parse(Console.ReadLine());
            double x = double.Parse(Console.ReadLine());
            double y = double.Parse(Console.ReadLine());

            string position = string.Empty;

            if (((x == x1 || x == x2) && (y >= y1 && y <= y2)) ||
                ((y == y1 || y == y2) && (x >= x1 && x <= x2)))
            { 
                position = "Border";
            }
            else
            {
                position = "Inside / Outside";
            }

            Console.WriteLine(position);

        }
    }
}
