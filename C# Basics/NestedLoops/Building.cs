using System;
using System.Net;

namespace Building
{
    class Program
    {
        static void Main(string[] args)
        {
            int floors = int.Parse(Console.ReadLine());
            int apartments = int.Parse(Console.ReadLine());

            for (int fl = floors; fl >= 1; fl--)
            {
                string prefix = string.Empty;

                if (fl == floors)
                {
                    prefix = "L";
                }
                else if (fl % 2 == 0)
                {
                    prefix = "O";
                }
                else if (fl % 2 != 0)
                {
                    prefix = "A";
                }

                string output = string.Empty;

                for (int apt = 0; apt < apartments; apt++)
                {
                    output += $"{prefix}{fl}{apt} ";
                }

                Console.WriteLine(output);
            }

        }
    }
}
