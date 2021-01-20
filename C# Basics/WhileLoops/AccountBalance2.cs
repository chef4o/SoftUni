using System;

namespace AccountBalance2
{
    class Program
    {
        static void Main(string[] args)
        {
            double sum = 0;

            while (true)
            {
                string add = Console.ReadLine();

                if (add != "NoMoreMoney")
                {
                    Convert.ToDouble(add);

                    if (Convert.ToDouble(add) < 0)
                    {
                        Console.WriteLine($"Invalid operation!\nTotal: {sum:f2}");
                        break;
                    }
                    else
                    {
                        Console.WriteLine($"Increase: {Convert.ToDouble(add):f2}");
                        sum += Convert.ToDouble(add);
                    }
                }

                else
                {
                    Console.WriteLine($"Total: {sum:f2}");
                    break;
                }

            }
        }
    }
}
