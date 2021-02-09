using System;

namespace Elevator
{
    class Program
    {
        static void Main(string[] args)
        {
            uint people = uint.Parse(Console.ReadLine());
            byte capacity = byte.Parse(Console.ReadLine());

            Console.WriteLine(Math.Ceiling((double)people / (double)capacity));
        }
    }
}
