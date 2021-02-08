using System;

namespace ExactSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            decimal sum = 0m;
            while (n > 0)
            {
                decimal a = decimal.Parse(Console.ReadLine());
                sum += a;
                n--;
            }

            Console.WriteLine(sum);
        }
    }
}
