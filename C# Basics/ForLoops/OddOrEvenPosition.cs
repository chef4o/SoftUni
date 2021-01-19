using System;
using System.Xml;

namespace OddOrEvenPosition
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            double oddSum = 0;
            double oddMin = double.MaxValue;
            double oddMax = double.MinValue;
            double evenSum = 0;
            double evenMin = double.MaxValue;
            double evenMax = double.MinValue;
            string output = string.Empty;

            for (int i = 1; i <= n; i++)
            {
                double number = double.Parse(Console.ReadLine());

                if (i % 2 == 0)
                {
                    evenSum += number;
                    if (number < evenMin)
                    {
                        evenMin = number;
                    }
                    if (number > evenMax)
                    {
                        evenMax = number;
                    }
                }

                if (i % 2 != 0)
                {
                    oddSum += number;
                    if (i % 2 != 0 && number < oddMin)
                    {
                        oddMin = number;
                    }
                    if (i % 2 != 0 && number > oddMax)
                    {
                        oddMax = number;
                    }
                }
            }

            if (n == 0)
            {
                output =    $"OddSum=0.00,\n" +
                            $"OddMin=No,\n" +
                            $"OddMax=No,\n" +
                            $"EvenSum=0.00,\n" +
                            $"EvenMin=No,\n" +
                            $"EvenMax=No";
            }
            else if (n == 1)
            {
                output =    $"OddSum={oddSum:f2},\n" +
                            $"OddMin={oddMin:f2},\n" +
                            $"OddMax={oddMax:f2},\n" +
                            $"EvenSum=0.00,\n" +
                            $"EvenMin=No,\n" +
                            $"EvenMax=No";
            }
            else
            {
                output =    $"OddSum={oddSum:f2},\n" +
                            $"OddMin={oddMin:f2},\n" +
                            $"OddMax={oddMax:f2},\n" +
                            $"EvenSum={evenSum:f2},\n" +
                            $"EvenMin={evenMin:f2},\n" +
                            $"EvenMax={evenMax:f2}";
            }

            Console.WriteLine(output);

        }
    }
}
