using System;
using System.Globalization;

namespace Cake
{
    class Program
    {
        static void Main(string[] args)
        {
            int lenght = int.Parse(Console.ReadLine());
            int width = int.Parse(Console.ReadLine());

            int cakeSize = lenght * width;
            int cakeConsumption = 0;
            string output = string.Empty;

            while (true)
            {
                string input = Console.ReadLine();
                if (input != "STOP")
                {
                    cakeConsumption += Convert.ToInt32(input);
                    if (cakeConsumption > cakeSize)
                    {
                        output = $"No more cake left! You need {cakeConsumption - cakeSize} pieces more.";
                        break;
                    }
                }
                else
                {
                    output = $"{cakeSize - cakeConsumption} pieces are left.";
                    break;
                }
            }

            Console.WriteLine(output);

        }
    }
}
