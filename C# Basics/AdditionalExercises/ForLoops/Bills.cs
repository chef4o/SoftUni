using System;

namespace Bills
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            double electricity = 0;
            double water = 0;
            double internet = 0;
            double others = 0;

            for (int i = 0; i < n; i++)
            {
                double el = double.Parse(Console.ReadLine());

                electricity += el;
                water += 20;
                internet += 15;
                others += (el + 20 + 15) * (1 + (20.0 / 100));

            }

            double average = (electricity + water + internet + others) / (n * 1.0);

            Console.WriteLine($"Electricity: {electricity:f2} lv\n" + 
                              $"Water: {water:f2} lv\n" + 
                              $"Internet: {internet:f2} lv\n" + 
                              $"Other: {others:f2} lv\n" + 
                              $"Average: {average:f2} lv");

        }
    }
}
