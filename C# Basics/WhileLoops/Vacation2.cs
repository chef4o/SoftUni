using System;
using System.Net.NetworkInformation;
using System.Xml;

namespace Vacation2
{
    class Program
    {
        static void Main(string[] args)
        {
            double neededMoney = double.Parse(Console.ReadLine());
            double availableFunds = double.Parse(Console.ReadLine());

            int daysWithoutSaving = 0;
            int totalDays = 0;
            string output = string.Empty;

            while (true)
            {
                string spendOrSave = Console.ReadLine();
                double amount = double.Parse(Console.ReadLine());

                totalDays++;

                if (spendOrSave == "spend")
                {
                    daysWithoutSaving++;
                    if (daysWithoutSaving == 5)
                    {
                        output = $"You can't save the money.\n{totalDays}";
                        break;
                    }
                    else
                    {
                        availableFunds -= amount;
                        if (availableFunds < 0)
                        {
                            availableFunds = 0;
                        }
                    }
                }
                else if (spendOrSave == "save")
                {
                    daysWithoutSaving = 0;
                    availableFunds += amount;
                    if (availableFunds >= neededMoney)
                    {
                        output = $"You saved the money for {totalDays} days.";
                        break;
                    }
                }

            }

            Console.WriteLine(output);
        }
    }
}
