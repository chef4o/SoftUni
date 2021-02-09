using System;

namespace BeerKegs
{
    class Program
    {
        static void Main(string[] args)
        {
            byte n = byte.Parse(Console.ReadLine());

            string biggest = string.Empty;
            double volume = 0;
            for (int i = 0; i < n; i++)
            {
                string model = Console.ReadLine();
                double r = double.Parse(Console.ReadLine());
                uint height = uint.Parse(Console.ReadLine());

                if (Math.Pow(r , 2) * height * Math.PI > volume)
                {
                    biggest = model;
                    volume = Math.Pow(r , 2) * height * Math.PI;
                }
            }

            Console.WriteLine(biggest);
        }       
    }
}
