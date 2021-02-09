using System;

namespace DigitsSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int j = int.Parse(Console.ReadLine());
            int sum = 0;

            while (j > 0)
            {
                sum += j % 10;
                j /= 10;
            }

            Console.WriteLine(sum);
        }
    }
}
