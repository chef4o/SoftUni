using System;

namespace PadawanEquipment
{
    class Program
    {
        static void Main(string[] args)
        {
            double budget = double.Parse(Console.ReadLine());
            int studentsCount = int.Parse(Console.ReadLine());
            double lightsaberPrice = double.Parse(Console.ReadLine());
            double robePrice = double.Parse(Console.ReadLine());
            double beltPrice = double.Parse(Console.ReadLine());

            double totalPrice = studentsCount * (robePrice + beltPrice) + Math.Ceiling(studentsCount * (1 + 10 / 100.0)) * lightsaberPrice;
            for (int i = 1; i <= studentsCount; i++)
            {
                if (i % 6 == 0)
                {
                    totalPrice -= beltPrice;
                }
            }

            if (totalPrice <= budget)
            {
                Console.WriteLine($"The money is enough - it would cost {totalPrice:f2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivan Cho will need {totalPrice - budget:f2}lv more.");
            }
        }
    }
}
