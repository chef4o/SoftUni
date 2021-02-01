using System;
using System.Diagnostics.Tracing;
using System.Xml;

namespace SquarFrame
{
    class Program
    {
        static void Main(string[] args)
        {
            int frame = int.Parse(Console.ReadLine());

            for (int i = 1; i <= frame; i++)
            {
                if (i == 1 || i == frame)
                {
                    Console.Write("+ ");
                }
                else
                {
                    Console.Write("| ");
                }
                for (int j = 1; j <= frame - 2; j++)
                {
                    Console.Write("- ");
                }

                if (i == 1 || i == frame)
                {
                    Console.WriteLine("+");
                }
                else
                {
                    Console.WriteLine("|");
                }
            }
        }
    }
}
