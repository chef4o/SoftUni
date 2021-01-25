using System;

namespace WeatherAdv
{
    class Program
    {
        static void Main(string[] args)
        {
            double degrees = double.Parse(Console.ReadLine());

            string weather = String.Empty;

            if (degrees <= 35 && degrees >= 26)
            {
                weather = "Hot";
            }
            else if (degrees < 26 && degrees >20)
            {
                weather = "Warm";
            }
            else if (degrees <= 20 && degrees >= 15)
            {
                weather = "Mild";
            }
            else if (degrees < 15 && degrees >= 12)
            {
                weather = "Cool";
            }
            else if (degrees < 12 && degrees >= 5)
            {
                weather = "Cold";
            }
            else
            {
                weather = "unknown";
            }

            Console.WriteLine(weather);

        }
    }
}
