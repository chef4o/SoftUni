using System;

namespace AccountBalance
{
    class Program
    {
        static void Main(string[] args)
        {

            double sum = 0;

            while (true)
            {
                string add = Console.ReadLine();

                if (add == "NoMoreMoney")
                {
                    Console.WriteLine($"Total: {sum:f2}");
                    break;
                }

                else
                {
                    double number = Convert.ToDouble(add);

                    if (number > 0)
                    {
                        Console.WriteLine($"Increase: {number:f2}");
                        sum += number;
                    }

                    else
                    {
                        Console.WriteLine($"Invalid operation!\nTotal: {sum:f2}");
                        break;
                    }
                }
            }

        }
    }
}
