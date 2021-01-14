using System;

namespace BonusPoints
{
    class Program
    {
        static void Main(string[] args)
        {
            int number = int.Parse(Console.ReadLine());

            double bonusPoints = 0.0;

            if (number <= 100)
            {
                bonusPoints = 5;
            }
            else if (number <= 1000)
            {
                bonusPoints = number * 20.0 / 100;
            }
            else
            {
                bonusPoints = number * 10.0 / 100;
            }

            if (number % 2 == 0)
            {
                bonusPoints += 1;
            }

            if (number % 10 == 5)
            {
                bonusPoints += 2;
            }

            Console.WriteLine(bonusPoints);
            Console.WriteLine(number + bonusPoints);

        }
    }
}
