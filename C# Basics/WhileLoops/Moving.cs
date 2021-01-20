using System;

namespace Moving
{
    class Program
    {
        static void Main(string[] args)
        {
            int w = int.Parse(Console.ReadLine());
            int l = int.Parse(Console.ReadLine());
            int h = int.Parse(Console.ReadLine());

            int availableSpace = w * h * l;
            int totalVolume = 0;
            string output = string.Empty;


            while (true)
            {
                string input = Console.ReadLine();

                if (input != "Done")
                {
                    int volume = Convert.ToInt32(input);
                    totalVolume += volume;

                    if (totalVolume > availableSpace)
                    {
                        output = $"No more free space! You need {Math.Abs(availableSpace - totalVolume)} Cubic meters more.";
                        break;
                    }
                }
                else
                {
                    output = $"{availableSpace - totalVolume} Cubic meters left.";
                    break;
                }
            }

            Console.WriteLine(output);
                
        }
    }
}
