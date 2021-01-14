using System;
using System.ComponentModel;
using System.Threading.Channels;

namespace Exercices2
{
    class Program
    {
        static void Main(string[] args)
        {
            int lap1 = int.Parse(Console.ReadLine());
            int lap2 = int.Parse(Console.ReadLine());
            int lap3 = int.Parse(Console.ReadLine());

            int totalSec = lap1 + lap2 + lap3;

            int sec = totalSec % 60;
            int min = totalSec / 60;

            if (sec < 10)
            {
                Console.WriteLine($"{min}:0{sec}");
            }
            else
            {
                Console.WriteLine($"{min}:{sec}");
            }
        }
    }
}
