using System;

namespace MinNumber
{
    class Program
    {
        static void Main(string[] args)
        {
            int min = int.MaxValue;

            while (true)
            {

                string input = Console.ReadLine();

                if (input != "Stop")
                {
                    int n = Convert.ToInt32(input);
                    if (n < min)
                    {
                        min = n;
                    }
                }
                else
                {
                    Console.WriteLine(min);
                    break;
                }
            }
        }
    }
}
