using System;

namespace Equal_sums
{
    class Program
    {
        static void Main(string[] args)
        {
            int sum1 = int.Parse(Console.ReadLine());
            int sum2 = int.Parse(Console.ReadLine());

            for (int i = sum1; i <= sum2; i++)
            {
                int evenSum = 0;
                int oddSum = 0;

                string number = i.ToString();
                for (int j = 0; j < number.Length; j++)
                {
                    string num = number[j].ToString();
                    if (j % 2 == 0)
                    {
                        evenSum += Convert.ToInt32(num);
                    }
                    else
                    {
                        oddSum += Convert.ToInt32(num);
                    }
                }

                if (evenSum == oddSum)
                {
                    Console.Write(number + " ");
                }
            }
        }
    }
}
