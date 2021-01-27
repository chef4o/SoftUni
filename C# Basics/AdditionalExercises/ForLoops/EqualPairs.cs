using System;


namespace EqualPairs
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int valueOne = 0;
            int valueTwo = 0;
            int maxValue = int.MinValue;
            int value = 0;
            string output = string.Empty;

            for (int i = 0; i < n; i++)
            {
                valueTwo = valueOne;
                valueOne = 0;

                int a = int.Parse(Console.ReadLine());
                int b = int.Parse(Console.ReadLine());

                valueOne = a + b;
                value = valueOne;

                if (valueOne == valueTwo || i == 0)
                {
                    value = valueOne;
                    output = $"Yes, value={value}";
                }
                else if (valueOne != valueTwo && i != 0)
                {
                    if (Math.Abs(valueOne - valueTwo) > maxValue)
                    {
                        maxValue = Math.Abs(valueOne - valueTwo);
                    }

                    output = $"No, maxdiff={maxValue}";
                }

            }
            
            Console.WriteLine(output);

        }
    }
}
