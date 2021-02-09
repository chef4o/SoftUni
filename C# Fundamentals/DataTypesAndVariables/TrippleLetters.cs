using System;

namespace TrippleLetters
{
    class Program
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());

            for (int i = ('a'); i < ('a') + input ; i++)
            {
                for (int j = ('a'); j < ('a') + input; j++)
                {
                    for (int k = ('a'); k < ('a') + input; k++)
                    {
                        Console.WriteLine($"{(char)i}{(char)j}{(char)k}");
                    }
                }
            }
        }
    }
}
