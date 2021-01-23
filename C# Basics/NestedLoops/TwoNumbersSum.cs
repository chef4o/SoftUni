using System;

namespace TwoNumbersSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int magic = int.Parse(Console.ReadLine());

            int combination = 0;
            bool isFound = false;

            for (int x1 = a; x1 <= b; x1++)
            {

                for (int x2 = a; x2 <= b; x2++)
                {
                    combination++;

                    if (x1 + x2 == magic)
                    {    
                        isFound = true;
                        Console.WriteLine($"Combination N:{combination} ({x1} + {x2} = {magic})");
                        break;
                    }

                    if (isFound)
                    {
                        break;
                    }
                }

                if (isFound)
                {
                    break;
                }
            }

            if (!isFound)
            {
                Console.WriteLine($"{combination} combinations - neither equals {magic}");
            }

        }
    }
}
