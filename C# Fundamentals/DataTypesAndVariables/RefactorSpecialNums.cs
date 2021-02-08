using System;

namespace RefactorSpecialNums
{
    class Program
    {
        static void Main(string[] args)
        {
            int input = int.Parse(Console.ReadLine());

            for (int i = 1; i <= input; i++)
            {
                int sum = 0;
                int j = i;

                while (j > 0)
                {
                    sum += j % 10;
                    j =  j / 10;
                }

                bool isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
                Console.WriteLine("{0} -> {1}", i, isSpecial);
            }
        }
    }
}
