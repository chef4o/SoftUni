using System;
using System.Transactions;

namespace NestedLoopsEx
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int number = 1;
            bool tooBig = false;

            for (int row = 1; row <= n; row++)
            {
                for (int column = 1; column <= row; column++)
                {
                    if (number > n)
                    {
                        tooBig = true;
                        break;
                    }

                    Console.Write(number + " ");
                    number++;
                }

                if (tooBig)
                {
                    break;
                }

                Console.WriteLine();
            }

        }
    }
}
