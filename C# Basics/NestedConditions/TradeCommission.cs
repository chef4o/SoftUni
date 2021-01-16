using System;
using System.ComponentModel.Design;

namespace TradeCommission
{
    class Program
    {
        static void Main(string[] args)
        {
            string city = Console.ReadLine();
            double sales = double.Parse(Console.ReadLine());

            double commission = 0;

            switch (city)
            {
                case "Sofia":
                    if (sales > 0 && sales <=500)
                    {
                        commission = sales * 5 / 100;
                    }
                    else if (sales > 500 && sales <= 1000)
                    {
                        commission = sales * 7 / 100;
                    }
                    else if (sales > 1000 && sales <= 10000)
                    {
                        commission = sales * 8 / 100;
                    }
                    else if (sales > 10000)
                    {
                        commission = sales * 12 / 100;
                    }
                    break;
                case "Varna":
                    if (sales > 0 && sales <= 500)
                    {
                        commission = sales * 4.5 / 100;
                    }
                    else if (sales > 500 && sales <= 1000)
                    {
                        commission = sales * 7.5 / 100;
                    }
                    else if (sales > 1000 && sales <= 10000)
                    {
                        commission = sales * 10 / 100;
                    }
                    else if (sales > 10000)
                    {
                        commission = sales * 13 / 100;
                    }
                    break;
                case "Plovdiv":
                    if (sales > 0 && sales <= 500)
                    {
                        commission = sales * 5.5 / 100;
                    }
                    else if (sales > 500 && sales <= 1000)
                    {
                        commission = sales * 8 / 100;
                    }
                    else if (sales > 1000 && sales <= 10000)
                    {
                        commission = sales * 12 / 100;
                    }
                    else if (sales > 10000)
                    {
                        commission = sales * 14.5 / 100;
                    }
                    break;
            }

            if (commission != 0)
            {
                Console.WriteLine($"{commission:f2}");
            }
            else
            {
                Console.WriteLine("error");
            }
        }
    }
}
