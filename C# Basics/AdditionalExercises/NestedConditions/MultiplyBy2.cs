using System;

namespace MultiplyBy2
{
    class Program
    {
        static void Main(string[] args)
        {

            while (true)
            {
                double number = double.Parse(Console.ReadLine());

                if (number < 0)
                {
                    Console.WriteLine("Negative number!");
                    break;
                }

                Console.WriteLine($"Result: {number * 2:f2}");

            }

        }
    }
}
