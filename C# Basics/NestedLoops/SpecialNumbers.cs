using System;

namespace SpecialNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1111; i <= 9999; i++)
            {
                string num = i.ToString();
                bool specialNum = false;

                for (int j = 0; j < num.Length; j++)
                {
                    if (int.Parse(num[j].ToString()) != 0 && n % int.Parse(num[j].ToString()) == 0)
                    {
                        specialNum = true;
                    }
                    else
                    {
                        specialNum = false;
                        break;
                    }
                }

                if (specialNum)
                {
                    Console.Write($"{num} ");
                }
            }
        }
    }
}
