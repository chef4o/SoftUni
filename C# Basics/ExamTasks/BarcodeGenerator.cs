using System;

namespace BarcodeGenerator
{
    class Program
    {
        static void Main(string[] args)
        {
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());

            string currentNum1 = num1.ToString();
            string currentNum2 = num2.ToString();

            for (int x1 = num1; x1 <= num2; x1++)
            {
                string digitTest = x1.ToString();

                bool goodNumber = true;

                for (int j = 0; j < currentNum1.Length; j++)
                {
                    int digitTest2 = int.Parse(digitTest[j].ToString());

                    if (digitTest2 % 2 != 0 
                        && digitTest2 >= Math.Min(int.Parse(currentNum2[j].ToString()), int.Parse(currentNum1[j].ToString())) 
                        && digitTest2 <= Math.Max(int.Parse(currentNum2[j].ToString()), int.Parse(currentNum1[j].ToString()))
                        )
                    {
                        goodNumber = true;
                    }
                    else
                    {
                        goodNumber = false;
                        break;
                    }
                }

                if (goodNumber)
                {
                    Console.Write($"{x1} ");
                }
            }
        }
    }
}