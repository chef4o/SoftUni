using System;

namespace UpperOrLower
{
    class Program
    {
        static void Main(string[] args)
        {
            char a = char.Parse(Console.ReadLine());

            bool isUpper = false;
            if ((int)a >= 65 && (int)a <= 90)
            {
                isUpper = true;
            }

            if (isUpper)
            {
                Console.WriteLine("upper-case");
            }
            else
            {
                Console.WriteLine("lower-case");
            }
        }
    }
}
