using System;

namespace RegistrationPlate
{
    class Program
    {
        static void Main(string[] args)
        {
            int start = int.Parse(Console.ReadLine());
            int end = int.Parse(Console.ReadLine());

            for (int x1= start; x1 <= end; x1++)
            {
                for (int x2 = start; x2 <= end; x2++)
                {
                    for (int x3 = start; x3 <= end; x3++)
                    {
                        for (int x4 = start; x4 <= end; x4++)
                        {
                            if (((x1 % 2 == 0 && x4 % 2 != 0) || (x1 % 2 != 0 && x4 % 2 == 0)) 
                                && x1 > x4 
                                && (x2 + x3) % 2 == 0)
                            {
                                Console.Write($"{x1}{x2}{x3}{x4} ");
                            }
                        }
                    }
                }
            }
        }
    }
}
