using System;
using System.Globalization;
using System.Xml;

namespace Salary
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int salary = int.Parse(Console.ReadLine());

            int fineFacebook = 0;
            int fineInstagram = 0;
            int fineReddit = 0;
            int totalFine = 0;
            string output = string.Empty;

            for (int i = 0; i < n; i++)
            {
                string website = Console.ReadLine();

                if (website == "Facebook")
                {
                    fineFacebook++;
                }
                if (website == "Instagram")
                {
                    fineInstagram++;
                }
                if (website == "Reddit")
                {
                    fineReddit++;
                }

                totalFine = fineFacebook * 150 + fineInstagram * 100 + fineReddit * 50;

                if (totalFine >= salary)
                {
                    output = "You have lost your salary.";
                    break;
                }
                else
                {
                    output = $"{salary - totalFine}";
                }
            }

            Console.WriteLine(output);
        }
    }
}
