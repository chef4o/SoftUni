using System;
using System.Xml;

namespace Vacation
{
    class Program
    {
        static void Main(string[] args)
        {
            double vacationPrice = double.Parse(Console.ReadLine());
            double availableSum = double.Parse(Console.ReadLine());

            int daysPassed = 0;
            int daysWithoutSaving = 0;
            string output = string.Empty;

            while (daysWithoutSaving < 5 && availableSum < vacationPrice)
            {
                string action = Console.ReadLine();
                double sum = double.Parse(Console.ReadLine());

                if (action == "spend")
                {
                    daysWithoutSaving++;
                    availableSum -= sum;
                    if (availableSum < 0)
                    {
                        availableSum = 0;
                    }
                }
                else if (action == "save")
                {
                    daysWithoutSaving = 0;
                    availableSum += sum;
                }

                daysPassed++;
            }

            if (daysWithoutSaving >= 5)
            {
                output = $"You can't save the money.\n{daysPassed}";
            }
            if (availableSum >= vacationPrice)
            {
                output = $"You saved the money for {daysPassed} days.";
            }

            Console.WriteLine(output);
        }
    }
}
