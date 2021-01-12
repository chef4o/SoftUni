using System;

namespace DepositCalc
{
    class Program
    {
        static void Main(string[] args)
        {
            double sum = double.Parse(Console.ReadLine());
            int months = int.Parse(Console.ReadLine());
            double intrate = double.Parse(Console.ReadLine());

            double savings = sum + (months * (sum * (intrate / 100) / 12));

            Console.WriteLine(savings);
        }
    }
}
