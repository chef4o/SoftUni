    using System;

    namespace MetricConvertor
    {
        class Program
        {
            static void Main(string[] args)
            {
                double inputNumber = double.Parse(Console.ReadLine());
                string inputMetric = Console.ReadLine();
                string outputMetric = Console.ReadLine();

                if (inputMetric == "mm" && outputMetric == "cm")
                {
                    inputNumber /= 10;
                }
                else if (inputMetric == "mm" && outputMetric == "m")
                {
                    inputNumber /= 1000;
                }
                else if (inputMetric == "cm" && outputMetric == "mm")
                {
                    inputNumber *= 10;
                }
                else if (inputMetric == "cm" && outputMetric == "m")
                {
                    inputNumber /= 100;
                }
                else if (inputMetric == "m" && outputMetric == "cm")
                {
                    inputNumber *= 100;
                }
                else if (inputMetric == "m" && outputMetric == "mm")
                {
                    inputNumber *= 1000;
                }

                Console.WriteLine($"{inputNumber:f3}");

            }
        }
    }
