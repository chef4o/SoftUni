using System;

namespace ProjectCreation
{
    class Program
    {
        static void Main(string[] args)
        {
            string name = Console.ReadLine();
            int count = int.Parse(Console.ReadLine());
            int time = count * 3;
            Console.WriteLine($"The architect {name} will need {time} hours to complete {count} project/s.");
        }
    }
}
